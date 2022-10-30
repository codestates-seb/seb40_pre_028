package com.seb40.server.Quesiton.Service;

import com.seb40.server.Exception.BusinessLogicException;
import com.seb40.server.Exception.ExceptionCode;
import com.seb40.server.Quesiton.Entity.Question;
import com.seb40.server.Quesiton.Repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class QuestionService {
    // (1)
    private final QuestionRepository questionRepository;

//    public QuestionService(QuestionRepository questionRepository) {
//        this.questionRepository = questionRepository;
//    }

    // 질문 등록
    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    // 질문 수정
    public Question updateQuestion(Question question){
        // questionId 확인
        Question findQuestion = findVerifiedQuestion(question.getQuestionId());
        // questionTitle 수정
        Optional.ofNullable(question.getQuestionTitle())
                .ifPresent(questionTitle ->findQuestion.setQuestionTitle(questionTitle));
        // questionBody 수정
        Optional.ofNullable(question.getQuestionBody())
                .ifPresent((question_body ->findQuestion.setQuestionBody(question_body)));
        // 수정 날짜 및 시간 수정
        Optional.ofNullable(question.getQuestionModified()) //업데이트 날짜 수정
                .ifPresent(questionModified->findQuestion.setQuestionModified(questionModified));
        return questionRepository.save(findQuestion);
    }

    // 선택 질문 요청
    public Question findQuestion(long questionId){

        return findVerifiedQuestion(questionId);
    }

    // 전체 질문 요청
    public Page<Question> findQuestions(int page, int size){
        return questionRepository.findAll(PageRequest.of(page,size,
                Sort.by("questionId").descending()));
    }

    // 질문 삭제
    public void deleteQuestion(long questionId){
        Question findQuestion = findVerifiedQuestion(questionId);
        questionRepository.delete(findQuestion);
    }

    // questionId 확인
    public Question findVerifiedQuestion(long questionId){
        Optional<Question> optionalQuestion=
                questionRepository.findByQuestionId(questionId); // 수정
        Question findQuestion=
                optionalQuestion.orElseThrow(()->
                        new BusinessLogicException(ExceptionCode.Question_NOT_FOUND));
        return findQuestion;
    }

}