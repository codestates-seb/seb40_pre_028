package com.seb40.server.Quesiton.Dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionTagDto { // 태그에 어떤 내용 들어가는지 만들었고,

    private long tagId;
    private String tagName;
}
