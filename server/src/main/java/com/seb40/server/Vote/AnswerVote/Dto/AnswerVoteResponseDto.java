package com.seb40.server.Vote.AnswerVote.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AnswerVoteResponseDto {

    private Long answerId;

    private int answerVoteSum;

}
