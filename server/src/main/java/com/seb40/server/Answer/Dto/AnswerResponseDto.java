package com.seb40.server.Answer.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class AnswerResponseDto {

    private long answerId;
    private String answerBody;
    private long userId;
    private LocalDateTime answerCreateAt;
    private LocalDateTime answerModified;

}