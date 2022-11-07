package com.seb40.server.Quesiton.Dto;

import com.seb40.server.Answer.Dto.AnswerResponseDto;
import com.seb40.server.Quesiton.Entity.QuestionTag;
import com.seb40.server.Tag.Entity.Tag;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionResponseDto {
    private Long questionId;
    private String questionTitle;
    private String questionBody;
    private LocalDateTime questionCreatedAt;
    private LocalDateTime questionModified;
    private List<AnswerResponseDto> answers;
    private List<Tag> tags;
    private String name;
    private int answerNum;
    private long views;
    private long questionVoteSum;
    private List<QuestionTag> questionTags;

}
