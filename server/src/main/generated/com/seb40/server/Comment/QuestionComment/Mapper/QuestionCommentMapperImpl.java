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
<<<<<<< HEAD
    date = "2022-11-07T10:53:13+0900",
=======
<<<<<<< HEAD
    date = "2022-11-05T22:41:46+0900",
>>>>>>> dev
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.16.1 (Azul Systems, Inc.)"
=======
    date = "2022-11-04T11:58:21+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.17 (Azul Systems, Inc.)"
>>>>>>> 1081e9adb982812f7d91689189b80dd89cd265a8
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
