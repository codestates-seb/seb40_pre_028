package com.seb40.server.Answer.Dto;

import com.seb40.server.Quesiton.Entity.Question;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AnswerResponseDto {
    // post 후 response 내용 answerId , userName, voteNum, answerBody, answerCommnetId


    private long answerId;
    private String answerBody;
//    private long userId;

    private long questionId;//추가

    private LocalDateTime answerCreatedAt;
    private LocalDateTime answerModified;



//    private int voteId; // id 로 vote 수 뽑기
//    private int commentId; // id 로 코멘트 내용 뽑기 list 형식

}
