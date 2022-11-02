package com.seb40.server.Vote.AnswerVote.Repository;

import com.seb40.server.Vote.AnswerVote.Entity.AnswerVote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnswerVoteRepostiory extends JpaRepository<AnswerVote, Long> {


    @Query("SELECT sum(av.answerVoteCnt) as answerVoteSum from answerVote av group by av.answer.answerId")
    List<Object[]> findByAnswerVoteCnt;

}
