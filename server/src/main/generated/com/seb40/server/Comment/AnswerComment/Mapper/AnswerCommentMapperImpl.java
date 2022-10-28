package com.seb40.server.Comment.AnswerComment.Mapper;

import com.seb40.server.Comment.AnswerComment.Dto.AnswerCommentPatchDto;
import com.seb40.server.Comment.AnswerComment.Dto.AnswerCommentPostDto;
import com.seb40.server.Comment.AnswerComment.Dto.AnswerCommentResponseDto;
import com.seb40.server.Comment.AnswerComment.Entity.AnswerComment;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-28T09:59:37+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.16.1 (Azul Systems, Inc.)"
)
@Component
public class AnswerCommentMapperImpl implements AnswerCommentMapper {

    @Override
    public AnswerComment commentPostDtoToComment(AnswerCommentPostDto commentPostDto) {
        if ( commentPostDto == null ) {
            return null;
        }

        AnswerComment answerComment = new AnswerComment();

        answerComment.setAnswerCommentId( commentPostDto.getAnswerCommentId() );
        answerComment.setAnswerId( commentPostDto.getAnswerId() );
        answerComment.setUserId( commentPostDto.getUserId() );
        answerComment.setAnswerCommentBody( commentPostDto.getAnswerCommentBody() );

        return answerComment;
    }

    @Override
    public AnswerComment commentPatchDtoToComment(AnswerCommentPatchDto commentPatchDto) {
        if ( commentPatchDto == null ) {
            return null;
        }

        AnswerComment answerComment = new AnswerComment();

        answerComment.setAnswerCommentId( commentPatchDto.getAnswerCommentId() );
        answerComment.setAnswerCommentBody( commentPatchDto.getAnswerCommentBody() );

        return answerComment;
    }

    @Override
    public AnswerCommentResponseDto commentToCommentResponseDto(AnswerComment comment) {
        if ( comment == null ) {
            return null;
        }

        long answerCommentId = 0L;
        long answerId = 0L;
        long userId = 0L;
        String answerCommentBody = null;
        LocalDateTime answerCommentCreateAt = null;

        if ( comment.getAnswerCommentId() != null ) {
            answerCommentId = comment.getAnswerCommentId();
        }
        if ( comment.getAnswerId() != null ) {
            answerId = comment.getAnswerId();
        }
        if ( comment.getUserId() != null ) {
            userId = comment.getUserId();
        }
        answerCommentBody = comment.getAnswerCommentBody();
        answerCommentCreateAt = comment.getAnswerCommentCreateAt();

        AnswerCommentResponseDto answerCommentResponseDto = new AnswerCommentResponseDto( answerCommentId, answerId, userId, answerCommentBody, answerCommentCreateAt );

        return answerCommentResponseDto;
    }
}
