package com.seb40.server.Quesiton.Mapper;

import com.seb40.server.Answer.Mapper.AnswerMapper;
import com.seb40.server.Quesiton.Dto.QuestionPatchDto;
import com.seb40.server.Quesiton.Dto.QuestionPostDto;
import com.seb40.server.Quesiton.Dto.QuestionResponseDto;
import com.seb40.server.Quesiton.Dto.QuestionResponseDto.QuestionResponseDtoBuilder;
import com.seb40.server.Quesiton.Entity.Question;
import com.seb40.server.User.entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-01T22:17:01+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.16.1 (Azul Systems, Inc.)"
)
@Component
public class QuestionMapperImpl implements QuestionMapper {

    @Override
    public Question questionPostDtoToQuestion(QuestionPostDto questionPostDto) {
        if ( questionPostDto == null ) {
            return null;
        }

        Question question = new Question();

        question.setQuestionId( questionPostDto.getQuestionId() );
        question.setQuestionTitle( questionPostDto.getQuestionTitle() );
        question.setQuestionBody( questionPostDto.getQuestionBody() );
        question.setUser( questionPostDtoToUser( questionPostDto ) );

        return question;
    }

    @Override
    public Question questionPatchDtoToQuestion(QuestionPatchDto questionPatchDto) {
        if ( questionPatchDto == null ) {
            return null;
        }

        Question question = new Question();

        question.setQuestionId( questionPatchDto.getQuestionId() );
        question.setQuestionTitle( questionPatchDto.getQuestionTitle() );
        question.setQuestionBody( questionPatchDto.getQuestionBody() );

        return question;
    }

    @Override
    public QuestionResponseDto questionToQuestionResponseDto(Question question, AnswerMapper answerMapper) {
        if ( question == null && answerMapper == null ) {
            return null;
        }

        QuestionResponseDtoBuilder questionResponseDto = QuestionResponseDto.builder();

        if ( question != null ) {
            questionResponseDto.questionId( question.getQuestionId() );
            questionResponseDto.questionTitle( question.getQuestionTitle() );
            questionResponseDto.questionBody( question.getQuestionBody() );
            questionResponseDto.questionCreatedAt( question.getQuestionCreatedAt() );
            questionResponseDto.questionModified( question.getQuestionModified() );
            questionResponseDto.answerNum( question.getAnswerNum() );
        }
        questionResponseDto.answers( answerMapper.answersToAnswerResponseDtos(question.getAnswers()) );
        questionResponseDto.name( question.getUser().getName() );

        return questionResponseDto.build();
    }

    protected User questionPostDtoToUser(QuestionPostDto questionPostDto) {
        if ( questionPostDto == null ) {
            return null;
        }

        User user = new User();

        user.setUserId( questionPostDto.getUserId() );

        return user;
    }
}
