package com.seb40.server.Quesiton.Repository;

import com.seb40.server.Quesiton.Entity.Question;
import com.seb40.server.Quesiton.Entity.QuestionTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionTagRepository extends JpaRepository<QuestionTag, Long> {
    @Query(value = "select * from questions_tag where question_id = :questionId",nativeQuery = true)
    List<QuestionTag> findAllByQuestionId(@Param("questionId") long questionId);


}