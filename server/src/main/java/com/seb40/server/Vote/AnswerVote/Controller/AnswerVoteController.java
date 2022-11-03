
package com.seb40.server.Vote.AnswerVote.Controller;


import com.seb40.server.Vote.AnswerVote.Dto.AnswerVotePatchDto;
import com.seb40.server.Vote.AnswerVote.Dto.AnswerVoteResponseDto;
import com.seb40.server.Vote.AnswerVote.service.AnswerVoteSevice;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.seb40.server.Vote.AnswerVote.Repository.AnswerVoteRepository;
import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController //bean 등록
@RequestMapping("/user")
@AllArgsConstructor
public class AnswerVoteController {
    private final AnswerVoteSevice answerVoteSevice;
    private final AnswerVoteRepository answerVoteRepository;

    //답변글 추천 비추천
    @PatchMapping("/vote")
    public ResponseEntity postVote(@Valid @RequestBody AnswerVotePatchDto answerVotePatchDto) {

        AnswerVoteResponseDto answerVoteResponseDto = new AnswerVoteResponseDto();
        answerVoteSevice.vote(answerVotePatchDto);

        //DB 내용을 확인 후 answerVoteSum 반환
        List<Object[]> list = answerVoteRepository.findByAnswerVoteCnt();

        //Long -> int
        Long answerid= answerVotePatchDto.getAnswerId();
        int index = answerid.intValue();

        //answerId에 대한 사용자 총투표값 확인
        Long answerId= Long.valueOf(list.get(index-1)[0].toString());
        Integer answerVoteSum = Integer.valueOf(list.get(index-1)[1].toString());


        answerVoteResponseDto.setAnswerId(answerId);
        answerVoteResponseDto.setAnswerVoteSum(answerVoteSum);


        return new ResponseEntity(answerVoteResponseDto, HttpStatus.CREATED);

    }

}

