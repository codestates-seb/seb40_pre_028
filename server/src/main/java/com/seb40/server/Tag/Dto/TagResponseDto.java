package com.seb40.server.Tag.Dto;


import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class TagResponseDto {

    private long tagId;
    private String tagName;

}
