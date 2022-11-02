package com.seb40.server.Quesiton.Controller;
import com.seb40.server.Answer.Mapper.AnswerMapper;
import com.seb40.server.Quesiton.Dto.QuestionPatchDto;
import com.seb40.server.Quesiton.Dto.QuestionPostDto;
import com.seb40.server.Quesiton.Entity.Question;
import com.seb40.server.Quesiton.Mapper.QuestionMapper;
import com.seb40.server.Quesiton.Repository.QuestionRepository;
import com.seb40.server.Quesiton.Service.QuestionService;
import com.seb40.server.Response.MultiResponseDto;
import com.seb40.server.Response.SingleResponseDto;
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
import java.util.Iterator;
import java.util.List;

@Transactional
@RequestMapping("/user/question")
@RestController
@AllArgsConstructor
public class QuestionController {
    private final QuestionService questionService;
    private final UserService userService;
    private final QuestionMapper mapper;
    private final AnswerMapper answerMapper;



    @PostMapping("/post")
    public ResponseEntity postQuestion(@RequestBody QuestionPostDto questionPostDto) {
        User user = userService.findVerifiedUser(questionPostDto.getUserId());
        questionPostDto.setName(user.getName());

        Question question = questionService.createQuestion(
                mapper.questionPostDtoToQuestion(questionPostDto));
        return new ResponseEntity<>(
                new SingleResponseDto<>(mapper.questionToQuestionResponseDto(question, answerMapper))
                , HttpStatus.CREATED);
    }

    // 선택 질문 수정 API
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

        return new ResponseEntity<>( //수정
                new SingleResponseDto<>(mapper.questionToQuestionResponseDto(response, answerMapper))
                , HttpStatus.OK);
    }

     //전체 질문페이지 이동 API
    @GetMapping
    public ResponseEntity getQuestions(@Positive @RequestParam int page,
                                       @Positive @RequestParam int size) {
        Page<Question> pageQuestions = questionService.findQuestions(page-1, size);
        List<Question> questions = pageQuestions.getContent();// 내용까지도

        //답변수 카운트
//        List<Object[]> list = questionRepository.findbyAnswerNum();
//
//        Iterator iter = list.iterator();
//        while(iter.hasNext()){
//            Object[] obj = (Object[]) iter.next();
//            String questionId = obj[0].toString();
//            int answerNum = Integer.valueOf(obj[1].toString());
//
//            System.out.printf("questionId : %s, answerNum : %d", questionId, answerNum );


        return new ResponseEntity<>(
                new MultiResponseDto<>(mapper.questionsToQuestionResponseDtos(questions),
                        pageQuestions),
                HttpStatus.OK);
    }


    // 선택 질문 삭제 API
    @DeleteMapping("/{question_id}")
    public ResponseEntity deleteQuestion(@PathVariable("question_id") @Positive long questionId) {
        questionService.deleteQuestion(questionId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


}