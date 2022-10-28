package com.seb40.server.Quesiton.Controller;
import com.seb40.server.Quesiton.Dto.QuestionPatchDto;
import com.seb40.server.Quesiton.Dto.QuestionPostDto;
import com.seb40.server.Quesiton.Dto.QuestionResponseDto;
import com.seb40.server.Quesiton.Entity.Question;
import com.seb40.server.Quesiton.Mapper.QuestionMapper;
import com.seb40.server.Quesiton.Service.QuestionService;
import com.seb40.server.Response.MultiResponseDto;
import com.seb40.server.Response.SingleResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;
@CrossOrigin
@Transactional
@RequestMapping("/user/question")
@RestController
public class QuestionController {
    private final QuestionService questionService;
    private final QuestionMapper mapper;
    public QuestionController(QuestionService questionService,
                              QuestionMapper mapper) {
        this.questionService = questionService;
        this.mapper = mapper;
    }

    // 질문 작성 API
    @PostMapping("/post")
    public ResponseEntity postQuestion(@RequestBody QuestionPostDto questionPostDto) {
        Question question = mapper.questionPostDtoToQuestion(questionPostDto);
        return new ResponseEntity<>(
                new SingleResponseDto<>(mapper.questionToQuestionResponseDto(question)),
                HttpStatus.CREATED);
    }
    // 선택 질문 수정 API
    @PatchMapping("/{question_id}")
    public ResponseEntity patchQuestion(@PathVariable("question_id") @Positive long questionId,
                                        @Valid @RequestBody QuestionPatchDto questionPatchDto) {
        questionPatchDto.setQuestionId(questionId);
        Question question =
                questionService.updateQuestion(mapper.questionPatchDtoToQuestion(questionPatchDto));
        return new ResponseEntity<>(
                new SingleResponseDto<>(mapper.questionToQuestionResponseDto(question)),
                HttpStatus.OK);
    }

    // 선택 질문페이지 이동 API(질문 선택하면 질문에 대한 정보와 답변을 할 수 있는 창으로 이동해야함) 슈벌 ㅈㄴ 어려움
    @GetMapping("/{question_id}")
    public ResponseEntity getQuestion(@PathVariable("question_id") @Positive long questionId) {
        Question question = questionService.findQuestion(questionId);
        return new ResponseEntity<>(
                new SingleResponseDto<>(mapper.questionToQuestionResponseDto(question)),
                HttpStatus.OK);
    }

    // 전체 질문페이지 이동 API
    @GetMapping
    public ResponseEntity getQuestions(@Positive @RequestParam int page,
                                       @Positive @RequestParam int size) {
        Page<Question> pageQuestions = questionService.findQuestions(page-1, size);
        List<Question> questions = pageQuestions.getContent();// 내용까지도
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