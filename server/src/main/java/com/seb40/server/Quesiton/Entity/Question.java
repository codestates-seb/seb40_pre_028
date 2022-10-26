package com.seb40.server.Quesiton.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Question {  // (1)
    @Id// (2)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long questionId;
    private String question_title;
    private String question_body;

}