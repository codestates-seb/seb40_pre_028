package com.seb40.server.Quesiton.Repository;

import com.seb40.server.Quesiton.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
