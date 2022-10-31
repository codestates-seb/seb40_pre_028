package com.seb40.server.Answer.Controller;


import com.seb40.server.Answer.Dto.AnswerPatchDto;
import com.seb40.server.Answer.Dto.AnswerPostDto;
import com.seb40.server.Answer.Dto.AnswerResponseDto;
import com.seb40.server.Answer.Entity.Answer;
//import com.seb40.server.ask.answer.mapper.AnswerMapper;
import com.seb40.server.Answer.Mapper.AnswerMapper;
import com.seb40.server.Answer.Repository.AnswerRepository;
import com.seb40.server.Comment.AnswerComment.Mapper.AnswerCommentMapper;
import com.seb40.server.Quesiton.Entity.Question;
import com.seb40.server.Quesiton.Repository.QuestionRepository;
import com.seb40.server.Quesiton.Service.QuestionService;
import com.seb40.server.Response.MultiResponseDto;
import com.seb40.server.Answer.Service.AnswerService;
import com.seb40.server.Response.SingleResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController //bean 등록
@RequestMapping("/user/answer")
@AllArgsConstructor
// 핸들러메서드 매핑, AnswerController클래스 전체에 사용되는 공통 Base URL 설정
public class AnswerController {

    // AnswerService, Mapper2 사용하기 위해 DI 주입
    private final AnswerService answerService;
    private final AnswerMapper mapper;
    private final AnswerCommentMapper answerCommentMapper;


//    @PostMapping("/post")
//    public ResponseEntity postAnswer(@RequestBody AnswerPostDto answerPostDto){
//        Answer answer = mapper.answerPostDtoToAnswer(answerPostDto);
//        Answer response = answerService.createAnswer(answer);
//
//        return new ResponseEntity<>(mapper.answerToAnswerResponseDto(response),
//                HttpStatus.CREATED);
//    }
//
//    @PostMapping("/{question_id}/post")
//    public ResponseEntity postAnswer(@PathVariable("question_id")
//                                         @Positive long questionId,
//                                     @RequestBody AnswerPostDto answerPostDto){
//        answerPostDto.setQuestionId(questionId);
//        Answer answer = mapper.answerPostDtoToAnswer(answerPostDto);
//        Answer response = answerService.createAnswer(answer);
//
//        return new ResponseEntity<>(mapper.answerToAnswerResponseDto(response),
//                HttpStatus.CREATED);
//    }

//    @PostMapping("/{question_id}/post")
//    public Answer createAnswer(@PathVariable ("question_id")
//                                   @Positive long questionId,
//                               @RequestBody Answer answer){
//        Optional<Question> question = questionRepository.findById(questionId);
//        answer.setQuestion(question.get());
//        answerRepository.save(answer);
//        return answer;
//    }

    @PostMapping("/{question_id}/post")
    public ResponseEntity postAnswer(@PathVariable("question_id")
                                         @Positive long questionId,
                                     @Valid @RequestBody AnswerPostDto answerPostDto){
        // answerPostDto 에 URI로 받은 questionId 설정
        answerPostDto.setQuestionId(questionId);
        Answer answer = answerService.createAnswer(
                mapper.answerPostDtoToAnswer(answerPostDto));

        return new ResponseEntity<>(
                new SingleResponseDto<>(mapper.answerToAnswerResponseDto(answer, answerCommentMapper)),
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
                new SingleResponseDto<>(mapper.answerToAnswerResponseDto(response,answerCommentMapper))
                , HttpStatus.OK);
    }

    @GetMapping("/{answer_id}")
    public ResponseEntity getAnswer(@PathVariable("answer_id")
                                    @Positive long answerId){
        Answer response = answerService.findVerifiedAnswer(answerId);

        return new ResponseEntity<>(
                new SingleResponseDto<>(mapper.answerToAnswerResponseDto(response,answerCommentMapper))
                , HttpStatus.OK);
    }

    // Get answer List
//    @GetMapping
//    public ResponseEntity getAnswers(@Positive @RequestParam int page,
//                                     @Positive @RequestParam int size) {
//        Page<Answer> pageAnswers = answerService.findAnswers(page - 1, size);
//        List<Answer> answers = pageAnswers.getContent();
//
//        return new ResponseEntity<>(
//                new MultiResponseDto<>(
//                        mapper.answersToAnswerResponseDtos(answers), pageAnswers),
//                HttpStatus.OK);
//    }

    //sh 추가
    @GetMapping("/sh")
    public List<AnswerResponseDto> getContents(){
        return answerService.getAllContents();
    }

    @GetMapping
    public ResponseEntity getAnswers(@Positive @RequestParam int page,
                                    @Positive @RequestParam int size) {

        Page<Answer> pageAnswers = answerService.findAnswers(page - 1, size);
        List<Answer> answers = pageAnswers.getContent();

        List<AnswerResponseDto> response = answerService.getAllContents();

        List<AnswerResponseDto> answerResponseDto = mapper.answersToAnswerResponseDtos(answers);
        List<AnswerResponseDto> answer1 = mapper.answerResponseDtoToAnswerResponseDtos(answerResponseDto);

        return new ResponseEntity<>(
                new MultiResponseDto<>(
                        answer1,pageAnswers),
                HttpStatus.OK);
//        @Query(value = "" +
//                "select question_id, count(*) as answerNum\n" +
//                "from answer\n" +
//                "group by question_id\n", nativeQuery = true)

    }

    @DeleteMapping("/{answer_id}")
    public ResponseEntity deleteAnswer(@PathVariable("answer_id")
                                           @Positive long answerId){
        // answerId 로 deleteAnswer 서비스 메소드로 삭제
        answerService.deleteAnswer(answerId);

        // 삭제요청, ok 반환
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
