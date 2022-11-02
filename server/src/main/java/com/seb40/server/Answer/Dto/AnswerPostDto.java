package com.seb40.server.Answer.Dto;

import com.seb40.server.Quesiton.Entity.Question;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

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
