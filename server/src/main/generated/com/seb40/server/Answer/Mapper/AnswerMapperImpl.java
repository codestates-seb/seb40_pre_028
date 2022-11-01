package com.seb40.server.Answer.Mapper;

import com.seb40.server.Answer.Dto.AnswerPatchDto;
import com.seb40.server.Answer.Dto.AnswerPostDto;
import com.seb40.server.Answer.Dto.AnswerResponseDto;
import com.seb40.server.Answer.Dto.AnswerResponseDto.AnswerResponseDtoBuilder;
import com.seb40.server.Answer.Entity.Answer;
import com.seb40.server.Comment.AnswerComment.Dto.AnswerCommentResponseDto;
import com.seb40.server.Comment.AnswerComment.Entity.AnswerComment;
import com.seb40.server.Comment.AnswerComment.Mapper.AnswerCommentMapper;
import com.seb40.server.Quesiton.Entity.Question;
import com.seb40.server.User.entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-01T22:17:01+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.16.1 (Azul Systems, Inc.)"
)
@Component
public class AnswerMapperImpl implements AnswerMapper {

    @Override
    public Answer answerPostDtoToAnswer(AnswerPostDto answerPostDto) {
        if ( answerPostDto == null ) {
            return null;
        }

        Answer answer = new Answer();

        answer.setAnswerId( answerPostDto.getAnswerId() );
        answer.setAnswerBody( answerPostDto.getAnswerBody() );
        answer.setQuestion( answerPostDtoToQuestion( answerPostDto ) );
        answer.setUser( answerPostDtoToUser( answerPostDto ) );

        return answer;
    }

    @Override
    public Answer answerPatchDtoToAnswer(AnswerPatchDto answerPatchDto) {
        if ( answerPatchDto == null ) {
            return null;
        }

        Answer answer = new Answer();

        answer.setAnswerId( answerPatchDto.getAnswerId() );
        answer.setAnswerBody( answerPatchDto.getAnswerBody() );

        return answer;
    }

    @Override
    public AnswerResponseDto answerToAnswerResponseDto(Answer answer, AnswerCommentMapper answerCommentMapper) {
        if ( answer == null && answerCommentMapper == null ) {
            return null;
        }

        AnswerResponseDtoBuilder answerResponseDto = AnswerResponseDto.builder();

        if ( answer != null ) {
            if ( answer.getAnswerId() != null ) {
                answerResponseDto.answerId( answer.getAnswerId() );
            }
            answerResponseDto.answerBody( answer.getAnswerBody() );
            answerResponseDto.answerCreatedAt( answer.getAnswerCreatedAt() );
            answerResponseDto.answerModified( answer.getAnswerModified() );
            answerResponseDto.answerComments( answerCommentListToAnswerCommentResponseDtoList( answer.getAnswerComments() ) );
        }

        return answerResponseDto.build();
    }

    protected Question answerPostDtoToQuestion(AnswerPostDto answerPostDto) {
        if ( answerPostDto == null ) {
            return null;
        }

        Question question = new Question();

        question.setQuestionId( answerPostDto.getQuestionId() );

        return question;
    }

    protected User answerPostDtoToUser(AnswerPostDto answerPostDto) {
        if ( answerPostDto == null ) {
            return null;
        }

        User user = new User();

        user.setUserId( answerPostDto.getUserId() );

        return user;
    }

    protected AnswerCommentResponseDto answerCommentToAnswerCommentResponseDto(AnswerComment answerComment) {
        if ( answerComment == null ) {
            return null;
        }

        AnswerCommentResponseDto answerCommentResponseDto = new AnswerCommentResponseDto();

        if ( answerComment.getAnswerCommentId() != null ) {
            answerCommentResponseDto.setAnswerCommentId( answerComment.getAnswerCommentId() );
        }
        if ( answerComment.getUserId() != null ) {
            answerCommentResponseDto.setUserId( answerComment.getUserId() );
        }
        answerCommentResponseDto.setAnswerCommentBody( answerComment.getAnswerCommentBody() );
        answerCommentResponseDto.setAnswerCommentCreateAt( answerComment.getAnswerCommentCreateAt() );

        return answerCommentResponseDto;
    }

    protected List<AnswerCommentResponseDto> answerCommentListToAnswerCommentResponseDtoList(List<AnswerComment> list) {
        if ( list == null ) {
            return null;
        }

        List<AnswerCommentResponseDto> list1 = new ArrayList<AnswerCommentResponseDto>( list.size() );
        for ( AnswerComment answerComment : list ) {
            list1.add( answerCommentToAnswerCommentResponseDto( answerComment ) );
        }

        return list1;
    }
}
