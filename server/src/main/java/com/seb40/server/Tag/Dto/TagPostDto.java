package com.seb40.server.Tag.Dto;


import com.seb40.server.Tag.Entity.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TagPostDto {

    private long tagId;
    private String tagName;
}
