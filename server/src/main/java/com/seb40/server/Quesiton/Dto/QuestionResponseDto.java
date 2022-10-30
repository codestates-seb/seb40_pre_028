package com.seb40.server.Quesiton.Dto;

import com.seb40.server.Answer.Dto.AnswerResponseDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class QuestionResponseDto { // userId라고 하면 DB에서 자동으로 user_id로 바꾸는듯
    private long questionId;
    private String questionTitle;
    private String questionBody;
    private LocalDateTime questionCreatedAt;
    private LocalDateTime questionModified;
    private List<AnswerResponseDto> answers; // 이 안에
    // answerId, answerBody, answerCreatedAt, answerModified
    // UserResponseDto user가 담김

    private long userId;

}
