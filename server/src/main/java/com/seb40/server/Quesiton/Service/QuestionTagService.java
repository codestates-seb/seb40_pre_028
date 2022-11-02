package com.seb40.server.Quesiton.Service;

import com.seb40.server.Quesiton.Entity.Question;
import com.seb40.server.Quesiton.Entity.QuestionTag;
import com.seb40.server.Quesiton.Repository.QuestionTagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuestionTagService { // 태그 삭제 안할거면 일단 status필요 없음 (일단 삽입을 구현)

    QuestionTagRepository questionTagRepository;

    // 태그를 만들어서 repository에 저장해
    public List<QuestionTag> createQuestionTags(List<QuestionTag> questionTags){
        return questionTags.stream().map(questionTag -> questionTagRepository.save(questionTag)).collect(Collectors.toList());
    }


}
