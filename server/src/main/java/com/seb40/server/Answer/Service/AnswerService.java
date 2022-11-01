package com.seb40.server.Answer.Service;

import com.seb40.server.Answer.Dto.AnswerResponseDto;
import com.seb40.server.Answer.Entity.Answer;
import com.seb40.server.Answer.Repository.AnswerRepository;
import com.seb40.server.Exception.BusinessLogicException;
import com.seb40.server.Exception.ExceptionCode;

import com.seb40.server.Quesiton.Entity.Question;
import com.seb40.server.Quesiton.Service.QuestionService;
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
public class AnswerService {
    private final AnswerRepository answerRepository;

//    public AnswerService(AnswerRepository answerRepository) {
//        this.answerRepository = answerRepository;
//    }

    // AnswerRepository 에 answer 저장 후 저장된 걸 반환하는 로직
    public Answer createAnswer(Answer answer){
        Answer savedAnswer = answerRepository.save(answer);

        return savedAnswer;
    }

    public Answer updateAnswer(Answer answer){
        // Answer Id 로 Answer를  찾는다.
        // controller에서 받은 answer파라미터의 answerId를 받아서 repository에 있는 answerId 확인 후
        // findAnswer에 찾아낸 answer 정보를 대입
        Answer findAnswer = findVerifiedAnswer(answer.getAnswerId());

        //findAnswer에 patch로 controller에서 들어온 answer파라미터의 body를 set한다.
        findAnswer.setAnswerBody(answer.getAnswerBody());
        // 새롭게 body가 set 된 Answer 를 repository에 저장 후 반환한다.
        return answerRepository.save(findAnswer);
    }

    public Answer findAnswer(long answerId){
        return findVerifiedAnswer(answerId);
    }


    // Answer를 page 로 찾기
    public Page<Answer> findAnswers(int page, int size) {
        return answerRepository.findAll(PageRequest.of(page, size,
                Sort.by("answerId")));
    }

    public void deleteAnswer(long answerId){
        // Answer 를 PK Answer Id 로 찾는다.
        Answer findAnswer = findVerifiedAnswer(answerId);
        // Repository 에서 삭제한다.
        answerRepository.delete(findAnswer);
        // 반환 X
    }

    // Answer Id 로 저장된 Answer 찾기
    public Answer findVerifiedAnswer(long answerId){

        Optional<Answer> optionalAnswer =
                answerRepository.findByAnswerId(answerId);
        Answer findAnswer =
                optionalAnswer.orElseThrow(()->
                        new BusinessLogicException(ExceptionCode.ANSWER_NOT_FOUND));

        return findAnswer;
    }



//    public List<AnswerResponseDto> getAllContents(){
//        return answerRepository.findAll().stream()
//                .map(AnswerResponseDto::fromEntity).collect(Collectors.toList());
//    }

}
