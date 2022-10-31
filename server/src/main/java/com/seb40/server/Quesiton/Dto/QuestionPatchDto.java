package com.seb40.server.Quesiton.Dto;

import lombok.Getter;

@Getter
public class QuestionPatchDto {
    private Long questionId;

    private String questionTitle;

    private String questionBody;

    public void setQuestionId(Long questionId){
        this.questionId = questionId;
    }
}