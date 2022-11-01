package com.seb40.server.Comment.AnswerComment.Mapper;

import com.seb40.server.Answer.Entity.Answer;
import com.seb40.server.Comment.AnswerComment.Dto.AnswerCommentPatchDto;
import com.seb40.server.Comment.AnswerComment.Dto.AnswerCommentPostDto;
import com.seb40.server.Comment.AnswerComment.Dto.AnswerCommentResponseDto;
import com.seb40.server.Comment.AnswerComment.Entity.AnswerComment;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-01T22:07:09+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.16.1 (Azul Systems, Inc.)"
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
        answerComment.setUserId( commentPostDto.getUserId() );
        answerComment.setAnswerCommentBody( commentPostDto.getAnswerCommentBody() );
        answerComment.setAnswer( answerCommentPostDtoToAnswer( commentPostDto ) );

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
    public List<AnswerCommentResponseDto> commentsToCommentResponseDtos(List<AnswerComment> comments) {
        if ( comments == null ) {
            return null;
        }

        List<AnswerCommentResponseDto> list = new ArrayList<AnswerCommentResponseDto>( comments.size() );
        for ( AnswerComment answerComment : comments ) {
            list.add( commentToCommentResponseDto( answerComment ) );
        }

        return list;
    }

    @Override
    public AnswerCommentResponseDto commentToCommentResponseDto(AnswerComment comment) {
        if ( comment == null ) {
            return null;
        }

        AnswerCommentResponseDto answerCommentResponseDto = new AnswerCommentResponseDto();

        if ( comment.getAnswerCommentId() != null ) {
            answerCommentResponseDto.setAnswerCommentId( comment.getAnswerCommentId() );
        }
        if ( comment.getUserId() != null ) {
            answerCommentResponseDto.setUserId( comment.getUserId() );
        }
        answerCommentResponseDto.setAnswerCommentBody( comment.getAnswerCommentBody() );
        answerCommentResponseDto.setAnswerCommentCreateAt( comment.getAnswerCommentCreateAt() );

        answerCommentResponseDto.setAnswerId( comment.getAnswer().getAnswerId() );

        return answerCommentResponseDto;
    }

    protected Answer answerCommentPostDtoToAnswer(AnswerCommentPostDto answerCommentPostDto) {
        if ( answerCommentPostDto == null ) {
            return null;
        }

        Answer answer = new Answer();

        answer.setAnswerId( answerCommentPostDto.getAnswerId() );

        return answer;
    }
}
