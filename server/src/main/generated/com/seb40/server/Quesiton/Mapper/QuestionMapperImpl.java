package com.seb40.server.Quesiton.Mapper;

import com.seb40.server.Answer.Mapper.AnswerMapper;
import com.seb40.server.Quesiton.Dto.QuestionPatchDto;
import com.seb40.server.Quesiton.Dto.QuestionPostDto;
import com.seb40.server.Quesiton.Dto.QuestionResponseDto;
import com.seb40.server.Quesiton.Dto.QuestionResponseDtos;
import com.seb40.server.Quesiton.Entity.Question;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-30T17:11:37+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.16.1 (Azul Systems, Inc.)"
)
@Component
public class QuestionMapperImpl implements QuestionMapper {

    @Override
    public Question questionPostDtoToQuestion(QuestionPostDto questionPostDto) {
        if ( questionPostDto == null ) {
            return null;
        }

        Question question = new Question();

        if ( questionPostDto.getQuestionId() != null ) {
            question.setQuestionId( questionPostDto.getQuestionId() );
        }
        question.setQuestionTitle( questionPostDto.getQuestionTitle() );
        question.setQuestionBody( questionPostDto.getQuestionBody() );

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

        QuestionResponseDto questionResponseDto = new QuestionResponseDto();

        if ( question != null ) {
            questionResponseDto.setQuestionId( question.getQuestionId() );
            questionResponseDto.setQuestionTitle( question.getQuestionTitle() );
            questionResponseDto.setQuestionBody( question.getQuestionBody() );
            questionResponseDto.setQuestionCreatedAt( question.getQuestionCreatedAt() );
            questionResponseDto.setQuestionModified( question.getQuestionModified() );
        }
        questionResponseDto.setAnswers( answerMapper.answersToAnswerResponseDtos(question.getAnswers()) );

        return questionResponseDto;
    }

    @Override
    public List<QuestionResponseDtos> questionsToQuestionResponseDtos(List<Question> questions) {
        if ( questions == null ) {
            return null;
        }

        List<QuestionResponseDtos> list = new ArrayList<QuestionResponseDtos>( questions.size() );
        for ( Question question : questions ) {
            list.add( questionToQuestionResponseDtos( question ) );
        }

        return list;
    }

    protected QuestionResponseDtos questionToQuestionResponseDtos(Question question) {
        if ( question == null ) {
            return null;
        }

        QuestionResponseDtos questionResponseDtos = new QuestionResponseDtos();

        questionResponseDtos.setQuestionId( question.getQuestionId() );
        questionResponseDtos.setQuestionTitle( question.getQuestionTitle() );
        questionResponseDtos.setQuestionBody( question.getQuestionBody() );
        questionResponseDtos.setQuestionCreatedAt( question.getQuestionCreatedAt() );
        questionResponseDtos.setQuestionModified( question.getQuestionModified() );

        return questionResponseDtos;
    }
}
