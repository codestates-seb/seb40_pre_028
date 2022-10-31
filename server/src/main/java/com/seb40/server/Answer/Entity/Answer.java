package com.seb40.server.Answer.Entity;



import com.seb40.server.Comment.AnswerComment.Entity.AnswerComment;
import com.seb40.server.Quesiton.Entity.Question;
import com.seb40.server.User.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
@Entity // DB 테이블 뜻 함
//@Table(name = "ANSWER") // 테이블 이름 명시, 클래스와 동일할 경우 생략가능
public class Answer {

    @Id // PK
    @Column(name="answer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Key 생성전략 MySQL의 auto_increment
    private Long answerId;

    // @ManyToOne 연결
//    @ManyToOne(targetEntity = Question.class) //추가
    @ManyToOne
    @JoinColumn(name="question_id")  //questionId ->question_id
    private Question question; //추가

    public void setQuestion(Question question){
        this.question = question;
    }

    @ManyToOne
    @JoinColumn(name ="user_id")
    private User user;

    public void setUser(User user){this.user = user;}

    @Column(nullable = false)
    private LocalDateTime answerCreatedAt = LocalDateTime.now();

    @Column(nullable = false)
    private LocalDateTime answerModified  = LocalDateTime.now();

    private String answerBody;

    @OneToMany(mappedBy = "answer", cascade = CascadeType.PERSIST)
    private List<AnswerComment> answerComments = new ArrayList<>();

    // 답변투표와 연결
//    private int answerVoteValue;

//    public Answer (String answerBody){
//
//        this.answerBody = answerBody;
//    }

}
