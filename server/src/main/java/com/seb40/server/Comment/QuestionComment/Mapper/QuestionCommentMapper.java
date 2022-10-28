package com.seb40.server.Comment.QuestionComment.Mapper;

import com.seb40.server.Comment.QuestionComment.Dto.QuestionCommentPatchDto;
import com.seb40.server.Comment.QuestionComment.Dto.QuestionCommentPostDto;
import com.seb40.server.Comment.QuestionComment.Dto.QuestionCommentResponseDto;
import com.seb40.server.Comment.QuestionComment.Entity.QuestionComment;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QuestionCommentMapper {

    QuestionComment commentPostDtoToComment(QuestionCommentPostDto commentPostDto);
    QuestionComment commentPatchDtoToComment(QuestionCommentPatchDto commentPatchDto);

    List<QuestionCommentResponseDto> commentsToCommentResponseDtos(List<QuestionComment> comments);
    QuestionCommentResponseDto commentToCommentResponseDto(QuestionComment comment);

}
