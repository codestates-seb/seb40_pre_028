package com.seb40.server.Comment.QuestionComment.Mapper;

import com.seb40.server.Comment.QuestionComment.Dto.QuestionCommentPatchDto;
import com.seb40.server.Comment.QuestionComment.Dto.QuestionCommentPostDto;
import com.seb40.server.Comment.QuestionComment.Dto.QuestionCommentResponseDto;
import com.seb40.server.Comment.QuestionComment.Entity.QuestionComment;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-30T20:28:23+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.16.1 (Azul Systems, Inc.)"
)
@Component
public class QuestionCommentMapperImpl implements QuestionCommentMapper {

    @Override
    public QuestionComment commentPostDtoToComment(QuestionCommentPostDto commentPostDto) {
        if ( commentPostDto == null ) {
            return null;
        }

        QuestionComment questionComment = new QuestionComment();

        questionComment.setQuestionCommentId( commentPostDto.getQuestionCommentId() );
        questionComment.setQuestionId( commentPostDto.getQuestionId() );
        questionComment.setUserId( commentPostDto.getUserId() );
        questionComment.setQuestionCommentBody( commentPostDto.getQuestionCommentBody() );

        return questionComment;
    }

    @Override
    public QuestionComment commentPatchDtoToComment(QuestionCommentPatchDto commentPatchDto) {
        if ( commentPatchDto == null ) {
            return null;
        }

        QuestionComment questionComment = new QuestionComment();

        questionComment.setQuestionCommentId( commentPatchDto.getQuestionCommentId() );
        questionComment.setQuestionCommentBody( commentPatchDto.getQuestionCommentBody() );

        return questionComment;
    }

    @Override
    public List<QuestionCommentResponseDto> commentsToCommentResponseDtos(List<QuestionComment> comments) {
        if ( comments == null ) {
            return null;
        }

        List<QuestionCommentResponseDto> list = new ArrayList<QuestionCommentResponseDto>( comments.size() );
        for ( QuestionComment questionComment : comments ) {
            list.add( commentToCommentResponseDto( questionComment ) );
        }

        return list;
    }

    @Override
    public QuestionCommentResponseDto commentToCommentResponseDto(QuestionComment comment) {
        if ( comment == null ) {
            return null;
        }

        long questionCommentId = 0L;
        long questionId = 0L;
        long userId = 0L;
        String questionCommentBody = null;
        LocalDateTime questionCommentCreateAt = null;

        if ( comment.getQuestionCommentId() != null ) {
            questionCommentId = comment.getQuestionCommentId();
        }
        if ( comment.getQuestionId() != null ) {
            questionId = comment.getQuestionId();
        }
        if ( comment.getUserId() != null ) {
            userId = comment.getUserId();
        }
        questionCommentBody = comment.getQuestionCommentBody();
        questionCommentCreateAt = comment.getQuestionCommentCreateAt();

        QuestionCommentResponseDto questionCommentResponseDto = new QuestionCommentResponseDto( questionCommentId, questionId, userId, questionCommentBody, questionCommentCreateAt );

        return questionCommentResponseDto;
    }
}
