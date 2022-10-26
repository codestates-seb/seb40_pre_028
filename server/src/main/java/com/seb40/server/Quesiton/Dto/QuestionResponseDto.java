package com.seb40.server.Quesiton.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionResponseDto {
    private long questionId;
    private String question_title;
    private String question_body;

}