package com.seb40.server.Quesiton.Mapper;

import com.seb40.server.Answer.Dto.AnswerResponseDto;
import com.seb40.server.Answer.Entity.Answer;
import com.seb40.server.Answer.Mapper.AnswerMapper;
import com.seb40.server.Comment.AnswerComment.Dto.AnswerCommentResponseDto;
import com.seb40.server.Comment.AnswerComment.Entity.AnswerComment;
import com.seb40.server.Quesiton.Dto.QuestionPatchDto;
import com.seb40.server.Quesiton.Dto.QuestionPostDto;
import com.seb40.server.Quesiton.Dto.QuestionResponseDto;
import com.seb40.server.Quesiton.Entity.Question;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-30T20:28:22+0900",
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
    public List<QuestionResponseDto> questionsToQuestionResponseDtos(List<Question> questions) {
        if ( questions == null ) {
            return null;
        }

        List<QuestionResponseDto> list = new ArrayList<QuestionResponseDto>( questions.size() );
        for ( Question question : questions ) {
            list.add( questionToQuestionResponseDto1( question ) );
        }

        return list;
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

    protected AnswerResponseDto answerToAnswerResponseDto(Answer answer) {
        if ( answer == null ) {
            return null;
        }

        AnswerResponseDto answerResponseDto = new AnswerResponseDto();

        answerResponseDto.setAnswerId( answer.getAnswerId() );
        answerResponseDto.setAnswerBody( answer.getAnswerBody() );
        answerResponseDto.setAnswerCreatedAt( answer.getAnswerCreatedAt() );
        answerResponseDto.setAnswerModified( answer.getAnswerModified() );
        answerResponseDto.setAnswerComments( answerCommentListToAnswerCommentResponseDtoList( answer.getAnswerComments() ) );

        return answerResponseDto;
    }

    protected List<AnswerResponseDto> answerListToAnswerResponseDtoList(List<Answer> list) {
        if ( list == null ) {
            return null;
        }

        List<AnswerResponseDto> list1 = new ArrayList<AnswerResponseDto>( list.size() );
        for ( Answer answer : list ) {
            list1.add( answerToAnswerResponseDto( answer ) );
        }

        return list1;
    }

    protected QuestionResponseDto questionToQuestionResponseDto1(Question question) {
        if ( question == null ) {
            return null;
        }

        QuestionResponseDto questionResponseDto = new QuestionResponseDto();

        questionResponseDto.setQuestionId( question.getQuestionId() );
        questionResponseDto.setQuestionTitle( question.getQuestionTitle() );
        questionResponseDto.setQuestionBody( question.getQuestionBody() );
        questionResponseDto.setQuestionCreatedAt( question.getQuestionCreatedAt() );
        questionResponseDto.setQuestionModified( question.getQuestionModified() );
        questionResponseDto.setAnswers( answerListToAnswerResponseDtoList( question.getAnswers() ) );

        return questionResponseDto;
    }
}
