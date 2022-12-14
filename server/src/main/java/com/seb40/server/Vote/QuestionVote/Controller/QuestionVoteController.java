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

        List<Object[]> list = questionVoteRepository.findByQuestionVoteCnt();

        Iterator iter = list.iterator();

        while (iter.hasNext()) {
            Object[] obj = (Object[]) iter.next();
            Long questionId = Long.valueOf(obj[0].toString());
            int questionVoteSum = Integer.parseInt(obj[1].toString());

            if(questionId == questionVotePatchDto.getQuestionId()) {

                questionVoteResponseDto.setQuestionId(questionId);
                questionVoteResponseDto.setQuestionVoteSum(questionVoteSum);
                break;
            }
            else {
                questionVoteResponseDto.setQuestionVoteSum(0);
            }

        }

        return new ResponseEntity(questionVoteResponseDto, HttpStatus.CREATED);

    }
}
