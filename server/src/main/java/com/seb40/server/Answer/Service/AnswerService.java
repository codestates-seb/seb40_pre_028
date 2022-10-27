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

    // AnswerRepository 에 answer 저장 후 저장된 걸 반환하는 로직s
    public Answer createdAnswer(Answer answer){
        Answer savedAnswer = answerRepository.save(answer);

        return savedAnswer;
    }

    public Answer updateAnswer(Answer answer){
        // Answer Id 로 Answer를  찾는다.
        Answer findAnswer = findVerifiedAnswer(answer.getAnswerId());
        // 찾은 내용에서 Answer 를 바꾼다.
//        Optional.ofNullable(answer.getAnswerBody())
//                .isPresent(answerBody -> findAnswer.setAnswerBody(answerBody));


        // 바꾼 Answer 를 저장 후 반환한다.
        return answerRepository.save(findAnswer);
    }

    public void deleteAnswer(long answerId){
        // Answer 를 PK Answer Id 로 찾는다.
        Answer findAnswer = findVerifiedAnswer(answerId);
        // Repository 에서 삭제한다.
        answerRepository.delete(findAnswer);
        // 반환 X
    }

    // Answer Id 로 Answer 찾기
    public Answer findVerifiedAnswer(long answerId){

        Optional<Answer> optionalAnswer =
                answerRepository.findByAnswerId(answerId);
        Answer findAnswer =
                optionalAnswer.orElseThrow(()->
                        new BusinessLogicException(ExceptionCode.ANSWER_NOT_FOUND));

        return findAnswer;
    }

}
