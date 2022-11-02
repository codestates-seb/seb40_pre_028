package com.seb40.server.Comment.AnswerComment.Mapper;

import com.seb40.server.Answer.Entity.Answer;
import com.seb40.server.Comment.AnswerComment.Dto.AnswerCommentPatchDto;
import com.seb40.server.Comment.AnswerComment.Dto.AnswerCommentPostDto;
import com.seb40.server.Comment.AnswerComment.Entity.AnswerComment;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-02T11:20:14+0900",
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

    protected Answer answerCommentPostDtoToAnswer(AnswerCommentPostDto answerCommentPostDto) {
        if ( answerCommentPostDto == null ) {
            return null;
        }

        Answer answer = new Answer();

        answer.setAnswerId( answerCommentPostDto.getAnswerId() );

        return answer;
    }
}
