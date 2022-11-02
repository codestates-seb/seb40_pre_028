package com.seb40.server.Comment.AnswerComment.Repository;

import com.seb40.server.Answer.Entity.Answer;
import com.seb40.server.Comment.AnswerComment.Entity.AnswerComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnswerCommentRepository extends JpaRepository<AnswerComment, Long> {
    Optional<AnswerComment> findByAnswerCommentId(long answerCommentId);
}
