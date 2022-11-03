package com.seb40.server.Vote.AnswerVote.Controller;

import com.seb40.server.Answer.Entity.Answer;
import com.seb40.server.Answer.Service.AnswerService;
import com.seb40.server.Response.SingleResponseDto;
import com.seb40.server.User.service.UserService;
import com.seb40.server.Vote.AnswerVote.Dto.AnswerVotePatchDto;

import com.seb40.server.Vote.AnswerVote.Entity.AnswerVote;
import com.seb40.server.Vote.AnswerVote.Mapper.AnswerVoteMapper;
import com.seb40.server.Vote.AnswerVote.Repository.AnswerVoteRepostiory;
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
public class AnswerVoteController {
    private final AnswerService answerService;

    private final AnswerVoteRepostiory answerVoteRepository;


    private final AnswerVoteMapper mapper;


    //답변글 추천 비추천


}
