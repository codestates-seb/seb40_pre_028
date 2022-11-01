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
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface AnswerMapper {

//    @Mapping(target = "question.questionId")
    @Mapping(target = "question.questionId")
    @Mapping(target = "user.userId")
    Answer answerPostDtoToAnswer(AnswerPostDto answerPostDto);

    Answer answerPatchDtoToAnswer(AnswerPatchDto answerPatchDto);

//    @Mapping(target = "answerComments",
//            expression = "java(answerCommentMapper.commentsToCommentResponseDtos(answer.getAnswerComments()))")
//    @Mapping(target = "userId", expression = "java(answer.getUser().getUserId())")
//    @Mapping(target = "questionId", expression = "java(answer.getQuestion().getQuestionId())")
//    @Mapping(source = "answer.user.userId", target = "userId")
//    @Mapping(source = "answer.question.questionId", target = "questionId")
//    AnswerResponseDto answerToAnswerResponseDto(Answer answer,AnswerCommentMapper answerCommentMapper);

    default AnswerResponseDto answerToAnswerResponseDto(Answer answer, AnswerCommentMapper answerCommentMapper){
        AnswerResponseDto answerResponseDto = new AnswerResponseDto();
        answerResponseDto.setQuestionId(answer.getQuestion().getQuestionId());
        answerResponseDto.setUserName(answer.getUser().getName());
        answerResponseDto.setAnswerBody(answer.getAnswerBody());
        answerResponseDto.setAnswerCreatedAt(answer.getAnswerCreatedAt());
        answerResponseDto.setAnswerModified(answer.getAnswerModified());

        return answerResponseDto;
    }

    // AnswerResponseDto 타입의 List mapper 파라미터로 List<Answer> 타입의 Answer 를 받는다.

    //   List<AnswerResponseDto> answersToAnswerResponseDtos(List<Answer> answers);
    default List<AnswerResponseDto> answersToAnswerResponseDtos(List<Answer> answers){
        return answers.stream()
                .map(answer -> AnswerResponseDto
                        .builder()
                        .questionId(answer.getQuestion().getQuestionId())
                        .userName(answer.getUser().getName())
                        .answerBody(answer.getAnswerBody())
                        .answerCreatedAt(answer.getAnswerCreatedAt())
                        .answerModified(answer.getAnswerModified())
                        .build())
                .collect(Collectors.toList());

    }

//    List<AnswerResponseDto> answerResponseDtoToAnswerResponseDtos(List<AnswerResponseDto> answerResponseDtos);

}
