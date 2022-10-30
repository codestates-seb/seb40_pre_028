package com.seb40.server.Quesiton.Repository;

import com.seb40.server.Answer.Entity.Answer;
import com.seb40.server.Quesiton.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    Optional<Question> findByQuestionId(long questionId);
}
