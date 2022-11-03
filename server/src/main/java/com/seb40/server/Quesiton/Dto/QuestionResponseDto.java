package com.seb40.server.Quesiton.Dto;

import com.seb40.server.Answer.Dto.AnswerResponseDto;
import com.seb40.server.Answer.Entity.Answer;
import com.seb40.server.Quesiton.Entity.Question;
import com.seb40.server.Tag.Dto.TagResponseDto;
import com.seb40.server.Tag.Entity.Tag;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class QuestionResponseDto { // userId라고 하면 DB에서 자동으로 user_id로 바꾸는듯
    private Long questionId;
    private String questionTitle;
    private String questionBody;
    private LocalDateTime questionCreatedAt;
    private LocalDateTime questionModified;
    private List<AnswerResponseDto> answers; // 이 안에
    private List<Tag> tags;
    private String name;
    private int answerNum;


}
