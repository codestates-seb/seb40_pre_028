package com.seb40.server.Quesiton.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@Getter
@Setter
public class QuestionPostDto {
    @Positive
    private Long questionId;


    private Long userId;
    private String name;

    @NotBlank
    private String questionTitle;

    @NotBlank
    private String questionBody;

    @NotNull(message = "태그를 기입해주세요.")
    private List<QuestionTagDto> questionTags;
}