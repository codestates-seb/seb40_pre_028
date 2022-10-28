package com.seb40.server.Comment.QuestionComment.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuestionCommentPostDto {

    private long questionCommentId;
    private long questionId;
    private long userId;

    @NotBlank
    private String questionCommentBody;

}
