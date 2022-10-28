package com.seb40.server.Answer.Entity;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Entity // DB 테이블 뜻 함
//@Table(name = "ANSWER") // 테이블 이름 명시, 클래스와 동일할 경우 생략가능
public class Answer {

    @Id // PK
    @Column(name="answer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Key 생성전략 MySQL의 auto_increment
    private long answerId;

    // @ManyToOne 연결
//    @ManyToOne
//    @JoinColumn(name="question_id")
    private long questionId;

    // @ManyToOne 연결
//    @ManyToOne
//    @JoinColumn(name ="user_id")
    private String userName;

    @Column(nullable = false)
    private LocalDateTime answerCreatedAt = LocalDateTime.now();

    @Column(nullable = false)
    private LocalDateTime answerModified  = LocalDateTime.now();

    private String answerBody;

    // 답변투표와 연결
//    private int answerVoteValue;

    public Answer (String answerBody){
        this.answerBody = answerBody;
    }
}
