package com.seb40.server.Answer.Entity;

import com.seb40.server.Quesiton.Entity.Question;
import com.seb40.server.User.entity.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity // DB 테이블 뜻 함
public class Answer {

    @Id // PK
    @Column(name="answer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Key 생성전략 MySQL의 auto_increment
    private Long answerId;

    @ManyToOne(targetEntity = Question.class)
    @JoinColumn(name="question_id")  //questionId ->question_id
    private Question question;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name ="user_id")
    private User user;

    public void setUser(User user){this.user = user;}

    @Column(nullable = false)
    private LocalDateTime answerCreatedAt = LocalDateTime.now();

    @Column(nullable = false)
    private LocalDateTime answerModified  = LocalDateTime.now();

    @Column(nullable = false)
    private String answerBody;

//    @OneToMany(mappedBy = "answer", cascade = CascadeType.PERSIST)
//    private List<AnswerComment> answerComments = new ArrayList<>();


}
