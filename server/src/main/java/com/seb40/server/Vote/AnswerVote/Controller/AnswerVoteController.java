
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
import java.util.Iterator;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController //bean 등록
@RequestMapping("/user")
@AllArgsConstructor
public class AnswerVoteController {
    private final AnswerVoteSevice answerVoteSevice;
    private final AnswerVoteRepository answerVoteRepository;

    //답변글 추천 비추천
    @PatchMapping("/answervote")
    public ResponseEntity postVote(@Valid @RequestBody AnswerVotePatchDto answerVotePatchDto) {

        AnswerVoteResponseDto answerVoteResponseDto = new AnswerVoteResponseDto();
        answerVoteSevice.vote(answerVotePatchDto);

        List<Object[]> list = answerVoteRepository.findByAnswerVoteCnt();

        Iterator iter = list.iterator();

        while (iter.hasNext()) {
            Object[] obj = (Object[]) iter.next();
            Long answerId = Long.valueOf(obj[0].toString());
            int answerVoteSum = Integer.parseInt(obj[1].toString());

            if(answerId == answerVotePatchDto.getAnswerId()){
                answerVoteResponseDto.setAnswerId(answerId);
                answerVoteResponseDto.setAnswerVoteSum(answerVoteSum);
                break;
            }
            else{
                answerVoteResponseDto.setAnswerVoteSum(0);
            }
        }

        return new ResponseEntity(answerVoteResponseDto, HttpStatus.CREATED);

    }
}

