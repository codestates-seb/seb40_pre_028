package com.seb40.server.Vote.AnswerVote.Mapper;

import com.seb40.server.Answer.Entity.Answer;
import com.seb40.server.User.entity.User;
import com.seb40.server.Vote.AnswerVote.Dto.AnswerVotePatchDto;
import com.seb40.server.Vote.AnswerVote.Entity.AnswerVote;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-07T10:53:13+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.16.1 (Azul Systems, Inc.)"
)
@Component
public class AnswerVoteMapperImpl implements AnswerVoteMapper {

    @Override
    public AnswerVote answerVotePatchDtoTOAnswerVote(AnswerVotePatchDto answerVotePatchDto) {
        if ( answerVotePatchDto == null ) {
            return null;
        }

        AnswerVote answerVote = new AnswerVote();

        answerVote.setUser( answerVotePatchDtoToUser( answerVotePatchDto ) );
        answerVote.setAnswer( answerVotePatchDtoToAnswer( answerVotePatchDto ) );
        answerVote.setAnswerVoteCnt( answerVotePatchDto.getAnswerVoteCnt() );

        return answerVote;
    }

    protected User answerVotePatchDtoToUser(AnswerVotePatchDto answerVotePatchDto) {
        if ( answerVotePatchDto == null ) {
            return null;
        }

        User user = new User();

        user.setUserId( answerVotePatchDto.getUserId() );

        return user;
    }

    protected Answer answerVotePatchDtoToAnswer(AnswerVotePatchDto answerVotePatchDto) {
        if ( answerVotePatchDto == null ) {
            return null;
        }

        Answer answer = new Answer();

        answer.setAnswerId( answerVotePatchDto.getAnswerId() );

        return answer;
    }
}
