package com.seb40.server.Tag.Mapper;

import com.seb40.server.Tag.Dto.TagPostDto;
import com.seb40.server.Tag.Dto.TagResponseDto;
import com.seb40.server.Tag.Entity.Tag;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-01T21:16:00+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.16.1 (Azul Systems, Inc.)"
)
@Component
public class TagMapperImpl implements TagMapper {

    @Override
    public Tag tagPostDtoToTag(TagPostDto tagPostDto) {
        if ( tagPostDto == null ) {
            return null;
        }

        Tag tag = new Tag();

        tag.setTagId( tagPostDto.getTagId() );
        tag.setTagName( tagPostDto.getTagName() );

        return tag;
    }

    @Override
    public TagResponseDto tagToTagResponseDto(Tag tag) {
        if ( tag == null ) {
            return null;
        }

        TagResponseDto tagResponseDto = new TagResponseDto();

        tagResponseDto.setTagId( tag.getTagId() );
        tagResponseDto.setTagName( tag.getTagName() );

        return tagResponseDto;
    }
}
