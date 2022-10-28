package com.seb40.server.Tag.Mapper;

import com.seb40.server.Tag.Dto.TagPostDto;
import com.seb40.server.Tag.Dto.TagResponseDto;
import com.seb40.server.Tag.Entity.Tag;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TagMapper {
    Tag tagPostDtoToTag(TagPostDto tagPostDto);
    TagResponseDto tagToTagResponseDto(Tag tag);
}
