package com.seb40.server.Quesiton.Dto;

import com.seb40.server.Answer.Dto.AnswerResponseDto;
import com.seb40.server.Answer.Entity.Answer;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder // sh 추가
public class QuestionResponseDto { // userId라고 하면 DB에서 자동으로 user_id로 바꾸는듯
    private Long questionId;
    private String questionTitle;
    private String questionBody;
    private LocalDateTime questionCreatedAt;
    private LocalDateTime questionModified;
    private List<AnswerResponseDto> answers; // 이 안에
    // answerId, answerBody, answerCreatedAt, answerModified
    // UserResponseDto user가 담김

    private Long userId;
    private int answerNum;

}
