package com.seb40.server.Quesiton.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuestionPostDto {
    @NotBlank
    private String question_title;

    @NotBlank
    private String question_body;
}