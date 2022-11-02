package com.seb40.server.Answer.Dto;

import com.seb40.server.Answer.Entity.Answer;
import com.seb40.server.Comment.AnswerComment.Dto.AnswerCommentResponseDto;
import com.seb40.server.Comment.AnswerComment.Entity.AnswerComment;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
//@Builder // sh 추가
@Builder
public class AnswerResponseDto {
    // post 후 response 내용 answerId , userName, voteNum, answerBody, answerCommnetId


    private long answerId;
    private String answerBody;
    private String name;

    private long questionId;

    private LocalDateTime answerCreatedAt;
    private LocalDateTime answerModified;
    private int answerNum;


//    private List<AnswerComment> answerComments;




//    public AnswerResponseDto(Answer answer){
//        this.answerId = answer.getAnswerId();
//        this.questionId = answer.getQuestion().getQuestionId();
//        this.name = answer.getUser().getName();
//        this.answerBody = answer.getAnswerBody();
//        this.answerCreatedAt = answer.getAnswerCreatedAt();
//        this.answerModified = answer.getAnswerModified();
////        this.answerComments = answer.getAnswerComments();
//    }



//    private int voteId; // id 로 vote 수 뽑기
//    private int commentId; // id 로 코멘트 내용 뽑기 list 형식

    //추가

//    public static AnswerResponseDto fromEntity(Answer answer){
//        return AnswerResponseDto.builder()
//                .answerId(answer.getAnswerId())
//                .answerBody(answer.getAnswerBody())
//                .questionId(answer.getQuestion().getQuestionId())
//                .answerCreatedAt(answer.getAnswerCreatedAt())
//                .answerModified(answer.getAnswerModified())
//                .userId(answer.getUser().getUserId())
//                .build();
//    }

}
