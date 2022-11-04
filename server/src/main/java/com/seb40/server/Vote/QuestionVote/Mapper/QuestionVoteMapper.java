package com.seb40.server.Vote.QuestionVote.Mapper;

import com.seb40.server.Vote.QuestionVote.Dto.QuestionVotePatchDto;
import com.seb40.server.Vote.QuestionVote.Entity.QuestionVote;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface QuestionVoteMapper {

    @Mapping(source = "userId", target = "user.userId")
    @Mapping(source = "questionId",target = "question.questionId")
    @Mapping(source = "questionVoteCnt",target = "questionVoteCnt")
    QuestionVote questionVotePatchDtoTOQuestionVote(QuestionVotePatchDto questionVotePatchDto);
}
