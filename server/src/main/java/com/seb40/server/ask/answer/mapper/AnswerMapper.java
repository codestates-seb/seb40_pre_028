package com.seb40.server.ask.answer.mapper;

import com.seb40.server.ask.answer.dto.AnswerPatchDto;
import com.seb40.server.ask.answer.dto.AnswerPostDto;
import com.seb40.server.ask.answer.dto.AnswerResponseDto;
import com.seb40.server.ask.answer.entity.Answer;
import org.springframework.stereotype.Component;

@Component // bean 등록
// Dto 클래스를 Answer 클래스로 변환
public class AnswerMapper {

    public Answer answerPostToAnswer(AnswerPostDto answerPostDto){
        return new Answer(answerPostDto.getAnswerId(),
                answerPostDto.getAnswerBody());
    }

    public Answer answerPatchDtoToAnswer(AnswerPatchDto answerPatchDto){
        return new Answer(
                answerPatchDto.getAnswerId(),
                answerPatchDto.getAnswerBody());
    }

    public AnswerResponseDto answerToAnswerResponseDto(Answer answer){
        return new AnswerResponseDto(
                answer.getAnswerId(),
                answer.getAnswerBody(),
                answer.getUserId(),
                answer.getAnswerCreateAt(),
                answer.getAnswerModified());
    }

}
