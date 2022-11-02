package com.seb40.server.Quesiton.Dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class QuestionTagResponseDto { // 태그에 대한 정보. 보여질 필드 적었고

    private long tagId;
    private String tagName;

}
