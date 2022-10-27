package com.seb40.server.Comment.AnswerComment.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnswerCommentPostDto {

    private long answerCommentId;

    @NotBlank
    private String answerCommentBody;
}
