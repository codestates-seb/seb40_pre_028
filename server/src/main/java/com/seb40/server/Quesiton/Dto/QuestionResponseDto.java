package com.seb40.server.Quesiton.Dto;

import com.seb40.server.Answer.Dto.AnswerResponseDto;
import com.seb40.server.Answer.Entity.Answer;
import com.seb40.server.Quesiton.Entity.Question;
import com.seb40.server.Quesiton.Entity.QuestionTag;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuestionResponseDto { // userId라고 하면 DB에서 자동으로 user_id로 바꾸는듯
    private Long questionId;
    private String questionTitle;
    private String questionBody;
    private LocalDateTime questionCreatedAt;
    private LocalDateTime questionModified;
    private List<AnswerResponseDto> answers;
    private String name;
    private int answerNum;

    private long views;

    private List<QuestionTagResponseDto> questionTags;



}
