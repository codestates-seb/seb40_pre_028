package com.seb40.server.Answer.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AnswerPostDto {

    @NotNull
    private long answerId;
    @Setter
    private long questionId;

    private String answerBody;

}
