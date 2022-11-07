package com.seb40.server.Comment.QuestionComment.Repository;

import com.seb40.server.Comment.AnswerComment.Entity.AnswerComment;
import com.seb40.server.Comment.QuestionComment.Entity.QuestionComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuestionCommentRepository extends JpaRepository<QuestionComment, Long> {

    Optional<AnswerComment> findByQuestionCommentId(long questionCommentId);
}
