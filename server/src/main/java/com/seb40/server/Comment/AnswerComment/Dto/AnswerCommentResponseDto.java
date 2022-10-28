package com.seb40.server.Comment.AnswerComment.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class AnswerCommentResponseDto {

    private long answerCommentId;
    private long answerId;
    private long userId;

    private String answerCommentBody;
    private LocalDateTime answerCommentCreateAt;

}
