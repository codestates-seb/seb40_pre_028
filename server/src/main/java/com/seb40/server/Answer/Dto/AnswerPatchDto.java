package com.seb40.server.Answer.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class AnswerPatchDto {

    private long answerId;
    private String answerBody;

}
