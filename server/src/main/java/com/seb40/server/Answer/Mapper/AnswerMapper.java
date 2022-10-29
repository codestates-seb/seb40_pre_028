package com.seb40.server.Answer.Mapper;

import com.seb40.server.Answer.Dto.AnswerPatchDto;
import com.seb40.server.Answer.Dto.AnswerPostDto;
import com.seb40.server.Answer.Dto.AnswerResponseDto;
import com.seb40.server.Answer.Entity.Answer;
import com.seb40.server.Answer.Service.AnswerService;
import com.seb40.server.Quesiton.Service.QuestionService;
import org.mapstruct.Mapper;

import java.util.List;

import static org.apache.coyote.http11.Constants.a;

@Mapper(componentModel = "spring")
public interface AnswerMapper {
    Answer answerPostDtoToAnswer(QuestionService questionService, AnswerPostDto answerPostDto);
    Answer answerPostDtoToAnswer(AnswerPostDto answerPostDto);
    Answer answerPatchDtoToAnswer(AnswerPatchDto answerPatchDto);
    AnswerResponseDto answerToAnswerResponseDto(Answer answer);
    // AnswerResponseDto 타입의 List mapper 파라미터로 List<Answer> 타입의 Answer 를 받는다.
    List<AnswerResponseDto> answersToAnswerResponseDtos(List<Answer> answers);


    }

