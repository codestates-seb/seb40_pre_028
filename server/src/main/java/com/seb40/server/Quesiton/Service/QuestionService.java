package com.seb40.server.Quesiton.Service;

import com.seb40.server.Exception.BusinessLogicException;
import com.seb40.server.Exception.ExceptionCode;
import com.seb40.server.Quesiton.Entity.Question;
import com.seb40.server.Quesiton.Repository.QuestionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    // (1)
    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Question createQuestion(Question question) {

        return questionRepository.save(question);  // (2)
    }

    public Question updateQuestion(Question question){
        Question findQuestion = findVerifiedQuestion(question.getQuestionId());
        Optional.ofNullable(question.getQuestionTitle())
                .ifPresent(questionTitle ->findQuestion.setQuestionTitle(questionTitle));
        Optional.ofNullable(question.getQuestionBody())
                .ifPresent((question_body ->findQuestion.setQuestionBody(question_body)));

        return questionRepository.save(findQuestion);
    }

    public Question findQuestion(long questionId){
        return findVerifiedQuestion(questionId);
    }

    public Page<Question> findQuestions(int page, int size){
        return questionRepository.findAll(PageRequest.of(page,size,
                Sort.by("questionId").descending()));
    }

    public void deleteQuestion(long questionId){
        Question findQuestion = findVerifiedQuestion(questionId);
        questionRepository.delete(findQuestion);
    }

    public Question findVerifiedQuestion(long questionId){
        Optional<Question> optionalQuestion=
                questionRepository.findById(questionId);
        Question findQuestion=
                optionalQuestion.orElseThrow(()->
                        new BusinessLogicException(ExceptionCode.Question_NOT_FOUND));
        return findQuestion;
    }

}