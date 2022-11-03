package com.seb40.server.Vote.AnswerVote.Entity;

import com.seb40.server.Answer.Entity.Answer;
import com.seb40.server.User.entity.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class AnswerVote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long answerVoteId;

    @OneToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(targetEntity = Answer.class)
    @JoinColumn(name = "answer_id")
    private Answer answer;

    @Column(name = "answerVoteCnt")
    public long answerVoteCnt;

}
