package com.seb40.server.Vote.QuestionVote.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class QuestionVoteResponseDto {

    private Long questionId;
    private int questionVoteSum;

}
