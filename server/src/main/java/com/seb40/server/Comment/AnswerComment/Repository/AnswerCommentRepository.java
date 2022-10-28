package com.seb40.server.Comment.AnswerComment.Repository;

import com.seb40.server.Comment.AnswerComment.Entity.AnswerComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerCommentRepository extends JpaRepository<AnswerComment, Long> {

}
