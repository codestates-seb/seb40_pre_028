package com.seb40.server.Answer.Controller;

import com.seb40.server.Answer.Dto.AnswerPatchDto;
import com.seb40.server.Answer.Dto.AnswerPostDto;
import com.seb40.server.Answer.Entity.Answer;
import com.seb40.server.Answer.Mapper.AnswerMapper;
import com.seb40.server.Quesiton.Service.QuestionService;
import com.seb40.server.Response.MultiResponseDto;
import com.seb40.server.Answer.Service.AnswerService;
import com.seb40.server.Response.SingleResponseDto;
import com.seb40.server.User.entity.User;
import com.seb40.server.User.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController //bean 등록
@RequestMapping("/user/answer")
@AllArgsConstructor
public class AnswerController {
    private final AnswerService answerService;

    private final QuestionService questionService;
    private final UserService userService;
    private final AnswerMapper mapper;

    @PostMapping("/{question_id}/post")
    public ResponseEntity postAnswer(@PathVariable("question_id") long questionId,
                                     @Valid @RequestBody AnswerPostDto answerPostDto){
        // answerPostDto 에 URI로 받은 questionId 설정
        answerPostDto.setQuestionId(questionId);
        User user = userService.findVerifiedUser(answerPostDto.getUserId());
        answerPostDto.setName(user.getName());

        Answer answer = answerService.createAnswer(
                mapper.answerPostDtoToAnswer(answerPostDto));

        return new ResponseEntity<>(
                new SingleResponseDto<>(mapper.answerToAnswerResponseDto(answer)),
                HttpStatus.CREATED);
    }




    @PatchMapping("/{answer_id}")
    public ResponseEntity patchAnswer(@PathVariable("answer_id")
                                          @Positive long answerId,
                                      @RequestBody AnswerPatchDto answerPatchDto){
        answerPatchDto.setAnswerId(answerId);
        Answer response = answerService.updateAnswer(
                mapper.answerPatchDtoToAnswer(answerPatchDto));

        return new ResponseEntity<>(
                new SingleResponseDto<>(mapper.answerToAnswerResponseDto(response))
                , HttpStatus.OK);
    }

    @GetMapping("/get/{answer_id}")
    public ResponseEntity getAnswer(@PathVariable("answer_id")
                                    @Positive long answerId){
        Answer answer = answerService.findAnswer(answerId);

        return new ResponseEntity<>(

                new SingleResponseDto<>(mapper.answerToAnswerResponseDto(answer))
                , HttpStatus.OK);
    }

    @GetMapping("/{question_id}")
    public ResponseEntity getAnswers(@PathVariable("question_id")@Positive long questionId,
                                     @Positive @RequestParam int page,
                                     @Positive @RequestParam int size) {


        Page<Answer> pageAnswers = answerService.findAnswers(page - 1, size);
        List<Answer> answers = pageAnswers.getContent();


        return new ResponseEntity<>(
                new MultiResponseDto<>(
                        mapper.answersToAnswerResponseDtos(answers), pageAnswers),
                HttpStatus.OK);

    }

    @DeleteMapping("/{answer_id}")
    public ResponseEntity deleteAnswer(@PathVariable("answer_id")
                                           @Positive long answerId){

        answerService.deleteAnswer(answerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
