package com.seb40.server.Quesiton.Service;

import com.seb40.server.Answer.Dto.AnswerResponseDto;
import com.seb40.server.Exception.BusinessLogicException;
import com.seb40.server.Exception.ExceptionCode;
import com.seb40.server.Quesiton.Dto.QuestionPostDto;
import com.seb40.server.Quesiton.Dto.QuestionResponseDto;
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
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository ;
    private final QuestionTagService questionTagService;

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
        Question updatedQuestion = questionRepository.save(findQuestion);
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

    public Question addViews(Question question){
        long views = question.getViews();
        views++;
        question.setViews(views);

        return questionRepository.save(question);
    }

    // 태그 검증
    public void addTags(QuestionPostDto questionPostDto){
        String tags = questionPostDto.getTags();

        for(int i = 0; i < tags.split(",").length; i++){

        }
    }
    // string  을 받아서 쪼개기
    // 쪼개진 string tag 를 중복 검사하기
    // 저장소에 있다면 저장소의 동일 tag Id를 가져오기
    // 저장소에 없다면 저장소에 저장해서 새로운 tag Id 를 받아서 List tags에 add 넣기
    // 넣은 List 를 question 의 tags 에 set 하기
}