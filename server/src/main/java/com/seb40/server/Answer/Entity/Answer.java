package com.seb40.server.Answer.Entity;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity // DB 테이블 뜻 함
//@Table(name = "ANSWER") // 테이블 이름 명시, 클래스와 동일할 경우 생략가능
public class Answer {

    @Id // PK
    @Column(name = "answer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Key 생성전략 MySQL의 auto_increment
    private long answerId;

    // @ManyToOne 연결해야함
    @Column(name = "question_id")
    private long questionId;

    // @ManyToOne 연결해야함
    @JoinColumn(name = "user_id")
    private long userId;

    @Column(name = "answer_createAt", nullable = false)
    private LocalDateTime answerCreatedAt = LocalDateTime.now();

    @Column(name = "answer_modied",nullable = false)
    private LocalDateTime answerModified  = LocalDateTime.now();

    @Column(name = "answer_body")
    private String answerBody;

}
