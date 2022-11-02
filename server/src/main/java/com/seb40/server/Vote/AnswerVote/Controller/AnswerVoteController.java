//package com.seb40.server.Vote.AnswerVote.Controller;
//
//import com.seb40.server.Answer.Service.AnswerService;
//import com.seb40.server.Response.SingleResponseDto;
//import com.seb40.server.User.service.UserService;
//import com.seb40.server.Vote.AnswerVote.Dto.AnswerVotePostDto;
//import lombok.AllArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//
//@RestController //bean 등록
//@RequestMapping("/user")
//@AllArgsConstructor
//public class AnswerVoteController {
//
//    private final AnswerService answerService;
//    private final UserService userService;
//    private final AswerVoteMapper mapper;
//
//
//    @PostMapping("/{answer_id}/vote")
//    public ResponseEntity postVote(@PathVariable("answer_id") long answerId,
//                                   @Valid @RequestBody AnswerVotePostDto answerVotePostDto){
//
//        answerVotePostDto.setAnswerId(answerId);
//
//        return new ResponseEntity<>(
//                new SingleResponseDto<>(mapper.voteToVoteResponseDto()), HttpStatus.CREATED)
//
//    }
//
//}
