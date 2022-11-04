package com.seb40.server.Vote.QuestionVote.Mapper;

import com.seb40.server.Quesiton.Entity.Question;
import com.seb40.server.User.entity.User;
import com.seb40.server.Vote.QuestionVote.Dto.QuestionVotePatchDto;
import com.seb40.server.Vote.QuestionVote.Entity.QuestionVote;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-04T11:58:21+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.17 (Azul Systems, Inc.)"
)
@Component
public class QuestionVoteMapperImpl implements QuestionVoteMapper {

    @Override
    public QuestionVote questionVotePatchDtoTOQuestionVote(QuestionVotePatchDto questionVotePatchDto) {
        if ( questionVotePatchDto == null ) {
            return null;
        }

        QuestionVote questionVote = new QuestionVote();

        questionVote.setUser( questionVotePatchDtoToUser( questionVotePatchDto ) );
        questionVote.setQuestion( questionVotePatchDtoToQuestion( questionVotePatchDto ) );
        questionVote.setQuestionVoteCnt( questionVotePatchDto.getQuestionVoteCnt() );

        return questionVote;
    }

    protected User questionVotePatchDtoToUser(QuestionVotePatchDto questionVotePatchDto) {
        if ( questionVotePatchDto == null ) {
            return null;
        }

        User user = new User();

        user.setUserId( questionVotePatchDto.getUserId() );

        return user;
    }

    protected Question questionVotePatchDtoToQuestion(QuestionVotePatchDto questionVotePatchDto) {
        if ( questionVotePatchDto == null ) {
            return null;
        }

        Question question = new Question();

        question.setQuestionId( questionVotePatchDto.getQuestionId() );

        return question;
    }
}
