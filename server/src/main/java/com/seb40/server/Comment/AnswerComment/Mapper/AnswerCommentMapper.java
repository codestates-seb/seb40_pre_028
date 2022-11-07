package com.seb40.server.Comment.AnswerComment.Mapper;

import com.seb40.server.Comment.AnswerComment.Dto.AnswerCommentPatchDto;
import com.seb40.server.Comment.AnswerComment.Dto.AnswerCommentPostDto;
import com.seb40.server.Comment.AnswerComment.Dto.AnswerCommentResponseDto;
import com.seb40.server.Comment.AnswerComment.Entity.AnswerComment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AnswerCommentMapper {

    @Mapping(target = "answer.answerId") // 추가
    AnswerComment commentPostDtoToComment(AnswerCommentPostDto commentPostDto);
    AnswerComment commentPatchDtoToComment(AnswerCommentPatchDto commentPatchDto);

    List<AnswerCommentResponseDto> commentsToCommentResponseDtos(List<AnswerComment> comments);
    @Mapping(target = "answerId", expression = "java(comment.getAnswer().getAnswerId())")
    AnswerCommentResponseDto commentToCommentResponseDto(AnswerComment comment);

}
