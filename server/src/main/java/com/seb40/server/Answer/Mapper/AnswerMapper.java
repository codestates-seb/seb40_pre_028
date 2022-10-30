package com.seb40.server.Answer.Mapper;

import com.seb40.server.Answer.Dto.AnswerPatchDto;
import com.seb40.server.Answer.Dto.AnswerPostDto;
import com.seb40.server.Answer.Dto.AnswerResponseDto;
import com.seb40.server.Answer.Entity.Answer;
import com.seb40.server.Comment.AnswerComment.Mapper.AnswerCommentMapper;
import com.seb40.server.Quesiton.Service.QuestionService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AnswerMapper {

    @Mapping(target = "question.questionId")
    @Mapping(target = "user.userId")
    Answer answerPostDtoToAnswer(AnswerPostDto answerPostDto);

    Answer answerPatchDtoToAnswer(AnswerPatchDto answerPatchDto);

    @Mapping(target = "answerComments",
            expression = "java(answerCommentMapper.commentsToCommentResponseDtos(answer.getAnswerComments()))")
    @Mapping(target = "userId", expression = "java(answer.getUser().getUserId())")
    @Mapping(target = "questionId", expression = "java(answer.getQuestion().getQuestionId())")
    AnswerResponseDto answerToAnswerResponseDto(Answer answer,AnswerCommentMapper answerCommentMapper);


    // AnswerResponseDto 타입의 List mapper 파라미터로 List<Answer> 타입의 Answer 를 받는다.
    List<AnswerResponseDto> answersToAnswerResponseDtos(List<Answer> answers);

}
