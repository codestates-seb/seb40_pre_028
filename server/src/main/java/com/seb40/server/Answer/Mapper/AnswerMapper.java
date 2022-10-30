package com.seb40.server.Answer.Mapper;

import com.seb40.server.Answer.Dto.AnswerPatchDto;
import com.seb40.server.Answer.Dto.AnswerPostDto;
import com.seb40.server.Answer.Dto.AnswerResponseDto;
import com.seb40.server.Answer.Entity.Answer;
import com.seb40.server.Quesiton.Service.QuestionService;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AnswerMapper {
    default Answer answerPostDtoToAnswer(AnswerPostDto answerPostDto, QuestionService questionService){
        Answer answer = new Answer();
        answer.setQuestion(questionService.findVerifiedQuestion(answerPostDto.getQuestionId()));
        answer.setAnswerBody(answerPostDto.getAnswerBody());

        return answer;
    }
    Answer answerPatchDtoToAnswer(AnswerPatchDto answerPatchDto);
    default AnswerResponseDto answerToAnswerResponseDto(Answer answer){
        AnswerResponseDto answerResponseDto = new AnswerResponseDto();
        answerResponseDto.setAnswerId(answer.getAnswerId());
        answerResponseDto.setQuestionId(answer.getQuestion().getQuestionId());
        answerResponseDto.setAnswerBody(answer.getAnswerBody());
        answerResponseDto.setAnswerCreatedAt(answer.getAnswerCreatedAt());
        answerResponseDto.setAnswerModified(answer.getAnswerModified());

        return answerResponseDto;
    }

    // AnswerResponseDto 타입의 List mapper 파라미터로 List<Answer> 타입의 Answer 를 받는다.
    List<AnswerResponseDto> answersToAnswerResponseDtos(List<Answer> answers);

}
