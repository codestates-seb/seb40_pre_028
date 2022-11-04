package com.seb40.server.Vote.QuestionVote.Repository;

import com.seb40.server.Vote.QuestionVote.Entity.QuestionVote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionVoteRepository extends JpaRepository<QuestionVote, Long> {

    @Query(value = "SELECT qv.question.questionId, sum(qv.questionVoteCnt) as questionVoteSum FROM QuestionVote qv GROUP BY qv.question.questionId")
    List<Object[]> findByQuestionVoteCnt();

    Optional<QuestionVote> findQuestionVotesByUser_UserIdAndQuestion_QuestionId(long userId, long questinoId);
}
