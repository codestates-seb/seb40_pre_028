package com.seb40.server.Quesiton.Dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
public class QuestionPatchDto {
    private Long questionId;

    private String questionTitle;

    private String questionBody;

    @Setter
    private List<QuestionTagDto> questionTags;

    public void setQuestionId(Long questionId){
        this.questionId = questionId;
    }
}