package com.seb40.server.Answer.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
public class AnswerPostDto {


    @NotNull
    private long answerId;
//    @Setter

//    @Positive // 양수여야함
    @Setter
    @NotNull // null 이 아닌 값.
    private long questionId;

    @NotNull
    private long userId;

    @NotBlank // null 이 아닌 값, 공백이 아니어야함
    private String answerBody;

}
