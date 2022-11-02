package com.seb40.server.Quesiton.Dto;

import com.seb40.server.Answer.Dto.AnswerResponseDto;
import com.seb40.server.Answer.Entity.Answer;
import com.seb40.server.Quesiton.Entity.Question;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
//@Builder // sh 추가
public class QuestionResponseDto { // userId라고 하면 DB에서 자동으로 user_id로 바꾸는듯
    private Long questionId;
    private String questionTitle;
    private String questionBody;
    private LocalDateTime questionCreatedAt;
    private LocalDateTime questionModified;
    private List<AnswerResponseDto> answers; // 이 안에

    // answerId, answerBody, answerCreatedAt, answerModified
    // UserResponseDto user가 담김

    private String name;
    private int answerNum;


//    public QuestionResponseDto(Question question){
//        this.questionId = question.getQuestionId();
//        this.questionTitle = question.getQuestionTitle();
//        this.questionBody = question.getQuestionBody();
//        this.questionCreatedAt = question.getQuestionCreatedAt();
//        this.questionModified = question.getQuestionModified();
//        this.answerNum = question.getAnswers().size();
//
//    }



    //    public static QuestionResponseDto fromEntity(Question question){
//        return QuestionResponseDto.builder()
//                .questionId(question.getQuestionId())
//                .questionBody(question.getQuestionBody())
//                .questionTitle(question.getQuestionTitle())
//                .questionCreatedAt(question.getQuestionCreatedAt())
//                .questionModified(question.getQuestionModified())
//                .name(question.getUser().getName())
//                .build();
//    }

}
