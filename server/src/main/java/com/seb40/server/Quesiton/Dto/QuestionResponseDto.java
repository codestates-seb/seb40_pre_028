package com.seb40.server.Quesiton.Dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class QuestionResponseDto {
    private long questionId;
    private String questionTitle;
    private String questionBody;
    private LocalDateTime questionCreateAt;
    private LocalDateTime questionModified;
}