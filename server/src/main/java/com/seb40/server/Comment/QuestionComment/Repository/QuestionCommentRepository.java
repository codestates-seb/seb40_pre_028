package com.seb40.server.Comment.QuestionComment.Repository;

import com.seb40.server.Comment.QuestionComment.Entity.QuestionComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionCommentRepository extends JpaRepository<QuestionComment, Long> {


}
