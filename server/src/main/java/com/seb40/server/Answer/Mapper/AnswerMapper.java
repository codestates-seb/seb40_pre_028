package com.seb40.server.Answer.Mapper;

import com.seb40.server.Answer.Dto.AnswerPatchDto;
import com.seb40.server.Answer.Dto.AnswerPostDto;
import com.seb40.server.Answer.Dto.AnswerResponseDto;
import com.seb40.server.Answer.Entity.Answer;
import com.seb40.server.Comment.AnswerComment.Mapper.AnswerCommentMapper;
import com.seb40.server.Quesiton.Service.QuestionService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AnswerMapper {

    @Mapping(target = "question.questionId")
    Answer answerPostDtoToAnswer(AnswerPostDto answerPostDto);
    Answer answerPatchDtoToAnswer(AnswerPatchDto answerPatchDto);

    @Mapping(target = "questionId", expression = "java(answer.getQuestion().getQuestionId())")
    @Mapping(target = "answerComments",
            expression = "java(answerCommentMapper.commentsToCommentResponseDtos(answer.getAnswerComments()))")
    AnswerResponseDto answerToAnswerResponseDto(Answer answer,AnswerCommentMapper answerCommentMapper);


    // AnswerResponseDto 타입의 List mapper 파라미터로 List<Answer> 타입의 Answer 를 받는다.
    List<AnswerResponseDto> answersToAnswerResponseDtos(List<Answer> answers);

}
