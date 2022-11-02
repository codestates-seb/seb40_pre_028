package com.seb40.server.Vote.AnswerVote.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
public class AnswerVotePatchDto {

    private long answerId;

    private long userId;

    private int answerVoteCnt;

}
