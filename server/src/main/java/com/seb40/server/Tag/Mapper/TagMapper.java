package com.seb40.server.Tag.Mapper;

import com.seb40.server.Quesiton.Dto.TagPostDto;
import com.seb40.server.Quesiton.Dto.TagResponseDto;
import com.seb40.server.Tag.Entity.Tag;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TagMapper {
    Tag tagPostDtoToTag(TagPostDto tagPostDto);
    TagResponseDto tagToTagResponseDto(Tag tag);
    List<TagResponseDto> tagsToTagResponseDtos(List<Tag> tags);
}
