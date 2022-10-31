package com.seb40.server.Comment.AnswerComment.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AnswerCommentResponseDto {

    private long answerCommentId;
    private long answerId;
    private long userId;

    private String answerCommentBody;
    private LocalDateTime answerCommentCreateAt;
}
