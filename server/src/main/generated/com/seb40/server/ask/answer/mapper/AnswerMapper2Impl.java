package com.seb40.server.ask.answer.Mapper;

import com.seb40.server.ask.answer.Dto.AnswerPatchDto;
import com.seb40.server.ask.answer.Dto.AnswerPostDto;
import com.seb40.server.ask.answer.Dto.AnswerResponseDto;
import com.seb40.server.ask.answer.Entity.Answer;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-26T18:02:10+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.16.1 (Azul Systems, Inc.)"
)
@Component
public class AnswerMapper2Impl implements AnswerMapper2 {

    @Override
    public Answer answerPostDtoToAnswer(AnswerPostDto answerPostDto) {
        if ( answerPostDto == null ) {
            return null;
        }

        Answer answer = new Answer();

        answer.setAnswerId( answerPostDto.getAnswerId() );
        answer.setAnswerBody( answerPostDto.getAnswerBody() );

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
    public AnswerResponseDto answerToAnswerResponseDto(Answer answer) {
        if ( answer == null ) {
            return null;
        }

        long answerId = 0L;
        String answerBody = null;
        long userId = 0L;
        LocalDateTime answerCreateAt = null;
        LocalDateTime answerModified = null;

        answerId = answer.getAnswerId();
        answerBody = answer.getAnswerBody();
        userId = answer.getUserId();
        answerCreateAt = answer.getAnswerCreateAt();
        answerModified = answer.getAnswerModified();

        AnswerResponseDto answerResponseDto = new AnswerResponseDto( answerId, answerBody, userId, answerCreateAt, answerModified );

        return answerResponseDto;
    }
}
