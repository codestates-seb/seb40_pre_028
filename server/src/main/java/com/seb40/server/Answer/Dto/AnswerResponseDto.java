package com.seb40.server.Answer.Dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class AnswerResponseDto {

    private long answerId;
    private String answerBody;
    private String name;

    private long questionId;

    private LocalDateTime answerCreatedAt;
    private LocalDateTime answerModified;
    private long answerVoteSum;

}
