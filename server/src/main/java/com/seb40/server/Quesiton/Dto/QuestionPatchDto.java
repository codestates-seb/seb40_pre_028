package com.seb40.server.Quesiton.Dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class QuestionPatchDto {
    private long questionId;
    private String questionTitle;
    private String questionBody;

    public void setQuestionId(long questionId){
        this.questionId = questionId;
    }
}