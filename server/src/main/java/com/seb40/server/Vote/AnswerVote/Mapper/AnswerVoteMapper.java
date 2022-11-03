package com.seb40.server.Vote.AnswerVote.Mapper;

import com.seb40.server.Vote.AnswerVote.Dto.AnswerVotePatchDto;
import com.seb40.server.Vote.AnswerVote.Entity.AnswerVote;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AnswerVoteMapper {

    @Mapping(source = "userId", target = "user.userId")
    @Mapping(source = "answerId",target = "answer.answerId")
    @Mapping(source = "answerVoteCnt",target = "answerVoteCnt")
    AnswerVote answerVotePatchDtoTOAnswerVote(AnswerVotePatchDto answerVotePatchDto);


}