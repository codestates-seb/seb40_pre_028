package com.seb40.server.Quesiton.Dto;

import com.seb40.server.Tag.Entity.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuestionPostDto {

    @Positive
    private Long questionId;


    private Long userId;
    private String name;

    @NotBlank
    private String questionTitle;

    @NotBlank
    private String questionBody;


//    @Valid
//    private List<Tag> tags;
//    public void setTags(List<Tag> tags) {
//        this.tags = tags;
//    }

    private String tags;

}