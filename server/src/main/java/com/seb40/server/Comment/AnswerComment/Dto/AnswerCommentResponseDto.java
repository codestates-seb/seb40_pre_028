package com.seb40.server.Comment.AnswerComment.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class AnswerCommentResponseDto {

    private long answerCommentId;
    private long answerId;
    private String userName;

    private String answerCommentBody;
    private LocalDateTime answerCommentCreateAt;
    private long commentNum;


}
