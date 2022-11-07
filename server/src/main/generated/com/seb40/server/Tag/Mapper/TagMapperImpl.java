package com.seb40.server.Tag.Mapper;

import com.seb40.server.Quesiton.Dto.TagPostDto;
import com.seb40.server.Quesiton.Dto.TagResponseDto;
import com.seb40.server.Quesiton.Dto.TagResponseDto.TagResponseDtoBuilder;
import com.seb40.server.Tag.Entity.Tag;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
<<<<<<< HEAD
    date = "2022-11-05T22:41:46+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.16.1 (Azul Systems, Inc.)"
=======
    date = "2022-11-04T11:58:22+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.17 (Azul Systems, Inc.)"
>>>>>>> 1081e9adb982812f7d91689189b80dd89cd265a8
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

        TagResponseDtoBuilder tagResponseDto = TagResponseDto.builder();

        if ( tag.getTagId() != null ) {
            tagResponseDto.tagId( tag.getTagId() );
        }
        tagResponseDto.tagName( tag.getTagName() );

        return tagResponseDto.build();
    }

    @Override
    public List<TagResponseDto> tagsToTagResponseDtos(List<Tag> tags) {
        if ( tags == null ) {
            return null;
        }

        List<TagResponseDto> list = new ArrayList<TagResponseDto>( tags.size() );
        for ( Tag tag : tags ) {
            list.add( tagToTagResponseDto( tag ) );
        }

        return list;
    }
}
