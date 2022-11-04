package com.seb40.server.Vote.QuestionVote.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class QuestionVotePatchDto {

    private long questionId;

    private long userId;

    private int questionVoteCnt;
}
