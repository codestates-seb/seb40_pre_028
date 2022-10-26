package com.seb40.server.Quesiton.Service;

import com.seb40.server.Exception.BusinessLogicException;
import com.seb40.server.Exception.ExceptionCode;
import com.seb40.server.Quesiton.Dto.QuestionResponseDto;
import com.seb40.server.Quesiton.Entity.Question;
import com.seb40.server.Quesiton.Repository.QuestionRepository;
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
        Optional.ofNullable(question.getQuestion_title())
                .ifPresent(question_title ->findQuestion.setQuestion_title(question_title));
        Optional.ofNullable(question.getQuestion_body())
                .ifPresent((question_body ->findQuestion.setQuestion_body(question_body)));

        return questionRepository.save(findQuestion);
    }

    public Question findQuestion(long questionId){
        return findVerifiedQuestion(questionId);
    }

    public List<Question> findQuestions(){
        return (List<Question>) questionRepository.findAll();
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
