package com.seb40.server.ask.answer.mapper;

import com.seb40.server.ask.answer.dto.AnswerPatchDto;
import com.seb40.server.ask.answer.dto.AnswerPostDto;
import com.seb40.server.ask.answer.dto.AnswerResponseDto;
import com.seb40.server.ask.answer.entity.Answer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AnswerMapper2 {
    Answer answerPostDtoToAnswer(AnswerPostDto answerPostDto);
    Answer answerPatchDtoToAnswer(AnswerPatchDto answerPatchDto);
    AnswerResponseDto answerToAnswerResponseDto(Answer answer);
}
