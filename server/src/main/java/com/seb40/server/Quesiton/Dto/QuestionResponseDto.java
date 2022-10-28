package com.seb40.server.Quesiton.Dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class QuestionResponseDto { // userId라고 하면 DB에서 자동으로 user_id로 바꾸는듯
    private long questionId;
    private long userId;
    private String questionTitle;
    private String questionBody;
    private LocalDateTime questionCreatedAt;
    private LocalDateTime questionModified;

}
