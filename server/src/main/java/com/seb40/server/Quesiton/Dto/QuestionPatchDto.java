package com.seb40.server.Quesiton.Dto;

import com.seb40.server.Tag.Dto.TagPostDto;
import lombok.Getter;

import javax.validation.Valid;
import java.util.List;

@Getter
public class QuestionPatchDto {
    private Long questionId;

    private String questionTitle;

    private String questionBody;

    @Valid
    private List<TagPostDto> tagPostDtos; // tagId, tagName;

    public void setQuestionId(Long questionId){
        this.questionId = questionId;
    }
}