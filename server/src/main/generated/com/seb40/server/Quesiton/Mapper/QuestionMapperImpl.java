package com.seb40.server.Quesiton.Mapper;

import com.seb40.server.Answer.Mapper.AnswerMapper;
import com.seb40.server.Quesiton.Dto.QuestionResponseDto;
import com.seb40.server.Quesiton.Dto.QuestionResponseDto.QuestionResponseDtoBuilder;
import com.seb40.server.Quesiton.Entity.Question;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-02T11:20:14+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.16.1 (Azul Systems, Inc.)"
)
@Component
public class QuestionMapperImpl implements QuestionMapper {

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
}
