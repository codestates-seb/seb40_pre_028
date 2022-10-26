package com.seb40.server.ask.answer.controller;


import com.seb40.server.ask.answer.dto.AnswerPatchDto;
import com.seb40.server.ask.answer.dto.AnswerPostDto;
import com.seb40.server.ask.answer.entity.Answer;
import com.seb40.server.ask.answer.mapper.AnswerMapper;
import com.seb40.server.ask.answer.service.AnswerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController //bean 등록
@RequestMapping("/user/answer") // 핸들러메서드 매핑, AnswerController클래스 전체에 사용되는 공통 Base URL 설정
public class AnswerController {

    private final AnswerService answerService;
    private final AnswerMapper mapper;

    public AnswerController(AnswerService answerService, AnswerMapper mapper) {
        this.answerService = answerService;
        this.mapper = mapper;
    }

    @PostMapping("/post")
    public ResponseEntity postAnswer(@RequestBody AnswerPostDto answerPostDto){
        Answer answer = mapper.answerPostToAnswer(answerPostDto);
        Answer response = answerService.creatAnswer(answer);

        return new ResponseEntity<>(mapper.answerToAnswerResponseDto(response),
                HttpStatus.CREATED);
    }

    @PatchMapping("/{answer_id}")
    public ResponseEntity patchAnswer(@RequestBody AnswerPatchDto answerPatchDto){
        Answer answer = mapper.answerPatchDtoToAnswer(answerPatchDto);
        Answer response = answerService.updateAnswer(answer);

        return new ResponseEntity<>(mapper.answerToAnswerResponseDto(response)
                , HttpStatus.OK);
    }

    @DeleteMapping("/{answer_id}")
    public ResponseEntity deleteAnswer(long answerId){
        // answerId 로 deleteAnswer 서비스 메소드로 삭제
        answerService.deleteAnswer(answerId);

        // 삭제요청, ok 반환
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
