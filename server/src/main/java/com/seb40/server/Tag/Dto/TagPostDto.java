package com.seb40.server.Tag.Dto;


import com.seb40.server.Tag.Entity.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TagPostDto {

    private long tagId;
    private String tagName;
}
