package com.seb40.server.Tag.Service;

import com.seb40.server.Answer.Entity.Answer;
import com.seb40.server.Exception.BusinessLogicException;
import com.seb40.server.Exception.ExceptionCode;
import com.seb40.server.Tag.Entity.Tag;
import com.seb40.server.Tag.Repository.TagRepository;

import java.util.Optional;

public class TagService {

    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public Tag createdTag(Tag tag) {
        Tag savedTag = tagRepository.save(tag);

        return savedTag;
    }

    public Tag getTag(long tagId){
        return findVerifiedTag(tagId);
    }

    public void deleteTag(long tagId){
        Tag findTag = findVerifiedTag(tagId);
        tagRepository.delete(findTag);
    }


    public Tag findVerifiedTag(long tagId){

        Optional<Tag> optionalTag =
                tagRepository.findByTagId(tagId);
        Tag findTag =
                optionalTag.orElseThrow(()->
                        new BusinessLogicException(ExceptionCode.TAG_NOT_FOUND));

        return findTag;
    }

}
