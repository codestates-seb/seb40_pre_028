package com.seb40.server.Answer.Mapper;

import com.seb40.server.Answer.Dto.AnswerResponseDto;
import com.seb40.server.Answer.Dto.AnswerResponseDto.AnswerResponseDtoBuilder;
import com.seb40.server.Answer.Entity.Answer;
import com.seb40.server.Quesiton.Entity.Question;
import com.seb40.server.User.entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-07T11:11:40+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.16.1 (Azul Systems, Inc.)"
)
@Component
public class AnswerMapperImpl implements AnswerMapper {

    @Override
    public AnswerResponseDto answerToAnswerResponseDto(Answer answer) {
        if ( answer == null ) {
            return null;
        }

        AnswerResponseDtoBuilder answerResponseDto = AnswerResponseDto.builder();

        answerResponseDto.name( answerUserName( answer ) );
        Long questionId = answerQuestionQuestionId( answer );
        if ( questionId != null ) {
            answerResponseDto.questionId( questionId );
        }
        if ( answer.getAnswerId() != null ) {
            answerResponseDto.answerId( answer.getAnswerId() );
        }
        answerResponseDto.answerBody( answer.getAnswerBody() );
        answerResponseDto.answerCreatedAt( answer.getAnswerCreatedAt() );
        answerResponseDto.answerModified( answer.getAnswerModified() );
        answerResponseDto.answerVoteSum( answer.getAnswerVoteSum() );

        return answerResponseDto.build();
    }

    private String answerUserName(Answer answer) {
        if ( answer == null ) {
            return null;
        }
        User user = answer.getUser();
        if ( user == null ) {
            return null;
        }
        String name = user.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private Long answerQuestionQuestionId(Answer answer) {
        if ( answer == null ) {
            return null;
        }
        Question question = answer.getQuestion();
        if ( question == null ) {
            return null;
        }
        Long questionId = question.getQuestionId();
        if ( questionId == null ) {
            return null;
        }
        return questionId;
    }
}
