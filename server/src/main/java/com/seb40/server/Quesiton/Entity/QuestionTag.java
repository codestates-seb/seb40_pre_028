package com.seb40.server.Quesiton.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.aspectj.weaver.patterns.TypePatternQuestions;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class QuestionTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tagId;

    @Column(nullable = false)
    private String tagName;

    @ManyToOne // 각자 매핑 끝냈고
    @JoinColumn(name="question_id")
    private Question question;

}



