package com.seb40.server.Vote.QuestionVote.Controller;

import com.seb40.server.Vote.QuestionVote.Dto.QuestionVotePatchDto;
import com.seb40.server.Vote.QuestionVote.Dto.QuestionVoteResponseDto;
import com.seb40.server.Vote.QuestionVote.Repository.QuestionVoteRepository;
import com.seb40.server.Vote.QuestionVote.service.QuestionVoteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Iterator;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController //bean 등록
@RequestMapping("/user")
@AllArgsConstructor
public class QuestionVoteController {

    private final QuestionVoteService questionVoteService;
    private final QuestionVoteRepository questionVoteRepository;

    //질문글 추천 비추천
    @PatchMapping("/questionvote")
    public ResponseEntity postVote(@Valid @RequestBody QuestionVotePatchDto questionVotePatchDto) {

        QuestionVoteResponseDto questionVoteResponseDto = new QuestionVoteResponseDto();
        questionVoteService.vote(questionVotePatchDto);

        //DB 내용을 확인 후 answerVoteSum 반환
        List<Object[]> list = questionVoteRepository.findByQuestionVoteCnt();

        //질문에 대한 투표값확인
        Iterator iter = list.iterator();

        while (iter.hasNext()) {
            Object[] obj = (Object[]) iter.next();
            Long questionId = Long.valueOf(obj[0].toString());
            int questionVoteSum = Integer.parseInt(obj[1].toString());

            questionVoteResponseDto.setQuestionId(questionId);
            questionVoteResponseDto.setQuestionVoteSum(questionVoteSum);

            if(questionId == questionVotePatchDto.getQuestionId()) break;
        }

        return new ResponseEntity(questionVoteResponseDto, HttpStatus.CREATED);

    }


}
