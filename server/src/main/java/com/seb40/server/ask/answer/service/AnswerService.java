package com.seb40.server.ask.answer.service;

import com.seb40.server.ask.answer.entity.Answer;

public class AnswerService {
    // repository di 주입

    public Answer creatAnswer(Answer answer){
        Answer createdAnswer = answer;

        return createdAnswer;
    }
    public Answer updateAnswer(Answer answer){
        Answer updatedAnswer = answer;

        return updatedAnswer;
    }

    public void deleteAnswer(long answerId){
        // 저장소에서 삭제
    }
}
