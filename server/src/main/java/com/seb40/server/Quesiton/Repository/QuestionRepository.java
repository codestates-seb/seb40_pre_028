package com.seb40.server.Quesiton.Repository;

import com.seb40.server.Answer.Entity.Answer;
import com.seb40.server.Quesiton.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    Optional<Question> findByQuestionId(long questionId);
}
