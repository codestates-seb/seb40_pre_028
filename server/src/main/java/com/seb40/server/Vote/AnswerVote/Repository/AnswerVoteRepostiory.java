package com.seb40.server.Vote.AnswerVote.Repository;

import com.seb40.server.Vote.AnswerVote.Entity.AnswerVote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerVoteRepostiory extends JpaRepository<AnswerVote, Long> {

    @Query(value = "SELECT av.answer.answerId, sum(av.answerVoteCnt) as answerVoteSum FROM AnswerVote av GROUP BY av.answer.answerId")
    List<Object[]> findByAnswerVoteCnt();



}
