package com.seb40.server.Vote.AnswerVote.Mapper;

import com.seb40.server.Answer.Dto.AnswerResponseDto;
import com.seb40.server.Answer.Entity.Answer;
import com.seb40.server.Vote.AnswerVote.Dto.AnswerVoteResponseDto;
import com.seb40.server.Vote.AnswerVote.Entity.AnswerVote;
import org.mapstruct.MapMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AnswerVoteMapper {

    AnswerVoteResponseDto answerToVoteResponseDto(Answer answer);

    @Mapping(source = "answerId", target = "answer.answerId")

    //answerVote.setAnswerVoteCnt( answer.getAnswerVoteSum() );
    //source = entity, target = dto
    @Mapping(source = "answer.answerVoteSum",target = "answerVoteCnt")
    AnswerVote answerToAnswerVote(Answer answer);
}