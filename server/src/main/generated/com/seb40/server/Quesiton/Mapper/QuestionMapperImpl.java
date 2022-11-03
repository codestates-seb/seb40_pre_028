package com.seb40.server.Quesiton.Mapper;

import com.seb40.server.Answer.Mapper.AnswerMapper;

import com.seb40.server.Quesiton.Dto.QuestionResponseDto;
import com.seb40.server.Quesiton.Dto.QuestionResponseDto.QuestionResponseDtoBuilder;
import com.seb40.server.Quesiton.Entity.Question;
import com.seb40.server.Tag.Mapper.TagMapper;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
<<<<<<< HEAD
    date = "2022-11-04T00:35:16+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.17 (Azul Systems, Inc.)"
=======
    date = "2022-11-02T11:20:14+0900",

    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.16.1 (Azul Systems, Inc.)"
>>>>>>> 06dcbaffcd10d9529ca58934d61bd58af8f155ab
)
@Component
public class QuestionMapperImpl implements QuestionMapper {

    @Override

<<<<<<< HEAD
        Question question = new Question();

        question.setQuestionId( questionPatchDto.getQuestionId() );
        question.setQuestionTitle( questionPatchDto.getQuestionTitle() );
        question.setQuestionBody( questionPatchDto.getQuestionBody() );

        return question;
    }

    @Override
    public QuestionResponseDto questionToQuestionResponseDto(Question question, AnswerMapper answerMapper, TagMapper tagMapper) {
        if ( question == null && answerMapper == null && tagMapper == null ) {
=======
    public QuestionResponseDto questionToQuestionResponseDto(Question question, AnswerMapper answerMapper) {
        if ( question == null && answerMapper == null ) {
>>>>>>> 06dcbaffcd10d9529ca58934d61bd58af8f155ab
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
        questionResponseDto.tags( question.getTags() );
        questionResponseDto.answers( answerMapper.answersToAnswerResponseDtos(question.getAnswers()) );
        questionResponseDto.name( question.getUser().getName() );

        return questionResponseDto.build();
    }
}
