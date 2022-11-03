package com.seb40.server.Answer.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;


@Getter
@Setter
@NoArgsConstructor
public class AnswerPostDto {

    private long answerId;

    private long questionId;

    private long userId;

    private String name;

    @NotBlank // null 이 아닌 값, 공백이 아니어야함
    private String answerBody;


}
