package com.seb40.server.Quesiton.Dto;

import lombok.Getter;

@Getter
public class QuestionPatchDto {
    private long questionId;

    private String question_title;

    private String question_body;

    public void setQuestionId(long questionId){
        this.questionId = questionId;
    }
}