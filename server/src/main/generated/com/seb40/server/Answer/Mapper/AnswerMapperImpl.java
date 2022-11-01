package com.seb40.server.Answer.Mapper;

import com.seb40.server.Answer.Dto.AnswerPatchDto;
import com.seb40.server.Answer.Dto.AnswerPostDto;
import com.seb40.server.Answer.Entity.Answer;
import com.seb40.server.Quesiton.Entity.Question;
import com.seb40.server.User.entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-01T23:17:09+0900",
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
}
