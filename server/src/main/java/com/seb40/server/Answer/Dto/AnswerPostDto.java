package com.seb40.server.Answer.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AnswerPostDto {

    private long answerId;
    private long questionId;
    private long userId;
    private String answerBody;

}
