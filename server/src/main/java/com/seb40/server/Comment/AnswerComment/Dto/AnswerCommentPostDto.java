package com.seb40.server.Comment.AnswerComment.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class AnswerCommentPostDto {

    private long answerCommentId;
    private long answerId;
    private long userId;

    @NotBlank
    private String answerCommentBody;
}
