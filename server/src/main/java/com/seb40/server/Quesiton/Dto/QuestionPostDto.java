package com.seb40.server.Quesiton.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuestionPostDto {
    @Positive
    private Long questionId;

    @Positive
    private Long userId;

    @NotBlank
    private String questionTitle;

    @NotBlank
    private String questionBody;
}