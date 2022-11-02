package com.seb40.server.Vote.AnswerVote.Controller;

import com.seb40.server.Answer.Repository.AnswerRepository;
import com.seb40.server.Answer.Service.AnswerService;
import com.seb40.server.Response.SingleResponseDto;
import com.seb40.server.User.service.UserService;
import com.seb40.server.Vote.AnswerVote.Dto.AnswerVotePatchDto;
import com.seb40.server.Vote.AnswerVote.Dto.AnswerVoteResponseDto;
import com.seb40.server.Vote.AnswerVote.Entity.AnswerVote;
import com.seb40.server.Vote.AnswerVote.Mapper.AnswerVoteMapper;
import com.seb40.server.Vote.AnswerVote.service.AnswerVoteSevice;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.seb40.server.Answer.Entity.Answer;
import com.seb40.server.Vote.AnswerVote.Repository.AnswerVoteRepostiory;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Iterator;
import java.util.List;

@RestController //bean 등록
@RequestMapping("/user")
@RequiredArgsConstructor
public class AnswerVoteController {

    private final AnswerService answerService;

    private final AnswerVoteRepostiory answerVoteRepository;

    private final AnswerVoteSevice answerVoteSevice;
    private final AnswerVoteMapper mapper;


    //답변글 추천 비추천
    @PatchMapping("/{answer_id}/vote")
    public ResponseEntity postVote(@PathVariable("answer_id") @Positive @NotNull long answerId,
                                   @Valid @RequestBody AnswerVotePatchDto answerVotePatchDto) {

        answerVoteSevice.voteAnswer(answerVotePatchDto);

        Answer answer = answerService.findVerifiedAnswer(answerVotePatchDto.getAnswerId());



        AnswerVote answerVote = mapper.answerToAnswerVote(answer);
        answerVote.setAnswerVoteCnt(answerVotePatchDto.getAnswerVoteCnt());

        //answervote DB 저장
        answerVoteRepository.save(answerVote);

        List<Object[]> list = answerVoteRepository.findByAnswerVoteCnt();
        Iterator iter = list.iterator();
        System.out.println("왜 안뜨는가1");

        while (iter.hasNext()) {
            Object[] obj = (Object[]) iter.next();
            System.out.println("왜 안뜨는가2");

            answerId = Long.valueOf(obj[0].toString());
            System.out.println("왜 안뜨는가3");

            int answerVoteSum = Integer.valueOf(obj[1].toString());

            System.out.printf("questionId : %d, answerNum : %d", answerId, answerVoteSum);

            answer.setAnswerId(answerId);
            answer.setAnswerVoteSum(answerVoteSum);


        }
        System.out.println("왜 안뜨는가4");


        return new ResponseEntity<>(
                new SingleResponseDto<>(mapper.answerToVoteResponseDto(answer)), HttpStatus.CREATED);

    }





}
