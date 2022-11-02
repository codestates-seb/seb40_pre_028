package com.seb40.server.Tag.Controller;


import com.seb40.server.Tag.Dto.TagPostDto;
import com.seb40.server.Tag.Entity.Tag;
import com.seb40.server.Tag.Mapper.TagMapper;
import com.seb40.server.Tag.Service.TagService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/tags")
public class TagController {

    private final TagService tagService;
    private final TagMapper mapper;

    public TagController(TagService tagService, TagMapper mapper) {
        this.tagService = tagService;
        this.mapper = mapper;
    }

    // 태그 POST
    @PostMapping("/post")
    public ResponseEntity postTag(@RequestBody TagPostDto tagPostDto){
        Tag tag = mapper.tagPostDtoToTag(tagPostDto);
        Tag response = tagService.createdTag(tag);

        return new ResponseEntity<>(mapper.tagToTagResponseDto(response),
                HttpStatus.CREATED);
    }


    // 태그id GET
    @GetMapping("/{tag_id}")
    public ResponseEntity getTagId(@PathVariable("tag_id")
                        @Positive long tagId){
        Tag response = tagService.findVerifiedTag(tagId);

        return new ResponseEntity<>(mapper.tagToTagResponseDto(response), HttpStatus.OK);
    }

    // 태그name GET ?


    // 태그 DELETE
    @DeleteMapping("/{tag_id}")
    public ResponseEntity deleteTag(@PathVariable("tag_id")
                                        @Positive long tagId){
        tagService.deleteTag(tagId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
