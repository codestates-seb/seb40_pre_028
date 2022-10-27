package com.seb40.server.Answer.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class AnswerResponseDto {
    // post 후 response 내용 answerId , userName, voteNum, answerBody, answerCommnetId


    private long answerId;
    private String answerBody;
    private long userId;
    private LocalDateTime answerCreateAt;
    private LocalDateTime answerModified;

    // private int voteId; // id 로 vote 수 뽑기
    // private int commentId; // id 로 코멘트 내용 뽑기 list 형식

}
