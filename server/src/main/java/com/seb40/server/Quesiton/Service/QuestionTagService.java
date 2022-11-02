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
public class QuestionTagService {

    QuestionTagRepository questionTagRepository;

    // 태그를 만들어
    public List<QuestionTag> createQuestionTags(List<QuestionTag> questionTags){
        return questionTags.stream().map(questionTag -> questionTagRepository.save(questionTag)).collect(Collectors.toList());
    }

//    public List<QuestionTag> findVerifiedQuestionTags(Question question){
//        List<QuestionTag> findQuestionTags= questionTagRepository.findAllByQuestionAndQuestionsTagStatus(question);
//        return findQuestionTags;
//    }



}
