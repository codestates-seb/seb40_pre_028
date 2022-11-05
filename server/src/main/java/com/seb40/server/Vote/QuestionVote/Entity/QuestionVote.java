package com.seb40.server.Vote.QuestionVote.Entity;

import com.seb40.server.Quesiton.Entity.Question;
import com.seb40.server.User.entity.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class QuestionVote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long questionVoteId;

    @OneToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(targetEntity = Question.class)
    @JoinColumn(name = "question_id")
    private Question question;

    @Column(name = "questionVote_cnt")
    public int questionVoteCnt;

}
