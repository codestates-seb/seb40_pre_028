package com.seb40.server.Comment.QuestionComment.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class QuestionCommentResponseDto {
    private long questionCommentId;
    private long questionId;
    private long userId;

    private String questionCommentBody;
    private LocalDateTime questionCommentCreateAt;
}
