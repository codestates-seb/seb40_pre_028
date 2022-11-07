package com.seb40.server.Quesiton.Dto;

import com.seb40.server.Answer.Dto.AnswerResponseDto;
import com.seb40.server.Quesiton.Entity.QuestionTag;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
public class QuestionsResponseDto {
    private Long questionId;
    private String questionTitle;
    private String questionBody;
    private LocalDateTime questionCreatedAt;
    private LocalDateTime questionModified;
    private List<AnswerResponseDto> answers;
    private String name;
    private int answerNum;
    private long views;
    private List<QuestionTag> questionTags;
    private long questionVoteSum;

}