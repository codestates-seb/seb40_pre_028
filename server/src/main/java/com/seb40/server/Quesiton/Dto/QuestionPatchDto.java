package com.seb40.server.Quesiton.Dto;


import com.seb40.server.Tag.Entity.Tag;
import lombok.Getter;
import java.util.List;
import javax.validation.Valid;

@Getter
public class QuestionPatchDto {
    private Long questionId;

    private String questionTitle;

    private String questionBody;

    @Valid
    private List<Tag> tags;

    public void setQuestionId(Long questionId){
        this.questionId = questionId;
    }
}