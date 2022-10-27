package com.seb40.server.Answer.Service;

import com.seb40.server.Answer.Entity.Answer;
import com.seb40.server.Answer.Repository.AnswerRepository;
import com.seb40.server.Exception.BusinessLogicException;
import com.seb40.server.Exception.ExceptionCode;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnswerService {
    private final AnswerRepository answerRepository;

    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    // AnswerRepository 에 answer 저장 후 저장된 걸 반환하는 로직
    public Answer createdAnswer(Answer answer){
        Answer savedAnswer = answerRepository.save(answer);

        return savedAnswer;
    }

    public Answer updateAnswer(Answer answer){
        // Answer 를 URI로 받는 Answer Id 로 동일한 내용를 찾는다.
        Answer findAnswer = findVerifiedAnswer(answer.getAnswerId());
        // 찾은 내용에서 Answer 를 바꾼다.
        Answer savedAnswer = answerRepository.save(findAnswer);

        // 바꾼 Answer 를 저장 후 반환한다.

        return savedAnswer;
    }

    public void deleteAnswer(long answerId){
        Answer findAnswer = findVerifiedAnswer(answerId);
        answerRepository.delete(findAnswer);
    }

    public Answer findVerifiedAnswer(long answerId){
        Optional<Answer> optionalAnswer =
                answerRepository.findByAnswerId(answerId);
        Answer findAnswer =
                optionalAnswer.orElseThrow(()->
                        new BusinessLogicException(ExceptionCode.ANSWER_NOT_FOUND));

        return findAnswer;
    }

}
