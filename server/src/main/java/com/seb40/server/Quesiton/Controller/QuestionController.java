package com.seb40.server.Quesiton.Controller;
import com.seb40.server.Answer.Mapper.AnswerMapper;
import com.seb40.server.Quesiton.Dto.QuestionPatchDto;
import com.seb40.server.Quesiton.Dto.QuestionPostDto;
import com.seb40.server.Quesiton.Entity.Question;
import com.seb40.server.Quesiton.Mapper.QuestionMapper;
import com.seb40.server.Quesiton.Service.QuestionService;
import com.seb40.server.Quesiton.Service.QuestionTagService;
import com.seb40.server.Response.MultiResponseDto;
import com.seb40.server.Response.SingleResponseDto;
import com.seb40.server.Tag.Mapper.TagMapper;
import com.seb40.server.User.entity.User;
import com.seb40.server.User.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Transactional
@RequestMapping("/user/question")
@RestController
@AllArgsConstructor
public class QuestionController {
    private final QuestionService questionService;
    private final QuestionMapper mapper;
    private final UserService userService;
    private final TagMapper tagMapper;
    private final AnswerMapper answerMapper;


    @PostMapping("/post")
    public ResponseEntity postQuestion(@RequestBody QuestionPostDto questionPostDto) {
        System.out.println(questionPostDto.getTags());

        User user = userService.findVerifiedUser(questionPostDto.getUserId());
        questionPostDto.setName(user.getName());


        Question question = questionService.createQuestion(
                mapper.questionPostDtoToQuestion(questionPostDto));
        return new ResponseEntity<>(
                new SingleResponseDto<>(mapper.questionToQuestionResponseDto(question, answerMapper))
                , HttpStatus.CREATED);
    }

    // ?????? ?????? ?????? API
    @PatchMapping("/{question_id}")
    public ResponseEntity patchQuestion(@PathVariable("question_id") @Positive long questionId,
                                        @Valid @RequestBody QuestionPatchDto questionPatchDto) {
        questionPatchDto.setQuestionId(questionId);
        Question response = questionService.updateQuestion(
                mapper.questionPatchDtoToQuestion(questionPatchDto));
        return new ResponseEntity<>(
                new SingleResponseDto<>(mapper.questionToQuestionResponseDto(response, answerMapper))
                , HttpStatus.OK);
    }


    @GetMapping("/{question_id}")
    public ResponseEntity getQuestion(@PathVariable("question_id") @Positive long questionId) {

        Question response = questionService.findQuestion(questionId);
        response = questionService.addViews(response);

        return new ResponseEntity<>( //??????
                new SingleResponseDto<>(mapper.questionToQuestionResponseDto(response, answerMapper))
                , HttpStatus.OK);
    }

     //?????? ??????????????? ?????? API
    @GetMapping
    public ResponseEntity getQuestions(@Positive @RequestParam int page,
                                       @Positive @RequestParam int size) {
        Page<Question> pageQuestions = questionService.findQuestions(page-1, size);
        List<Question> questions = pageQuestions.getContent();// ???????????????

        return new ResponseEntity<>(
                new MultiResponseDto<>(mapper.questionsToQuestionResponseDtos(questions),
                        pageQuestions),
                HttpStatus.OK);
    }


    // ?????? ?????? ?????? API
    @DeleteMapping("/{question_id}")
    public ResponseEntity deleteQuestion(@PathVariable("question_id") @Positive long questionId) {
        questionService.deleteQuestion(questionId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


}