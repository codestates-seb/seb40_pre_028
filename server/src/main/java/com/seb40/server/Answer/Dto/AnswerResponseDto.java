package com.seb40.server.Answer.Dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class AnswerResponseDto {
    // post 후 response 내용 answerId , userName, voteNum, answerBody, answerCommnetId


    private long answerId;
    private String answerBody;
    private String name;

    private long questionId;

    private LocalDateTime answerCreatedAt;
    private LocalDateTime answerModified;
    private int answerNum;

//    private List<AnswerComment> answerComments;
}
