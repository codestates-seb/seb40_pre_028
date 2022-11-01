package com.seb40.server.Comment.AnswerComment.Entity;

import com.seb40.server.Answer.Entity.Answer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "answer_comment")
public class AnswerComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answerCommentId;

    @ManyToOne
    @JoinColumn(name="answer_id")
    private Answer answer; //추가

    @Column( nullable = false)
    private Long userId;

    @Column( nullable = false)
    private String answerCommentBody;

    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime answerCommentCreateAt  = LocalDateTime.now();

}
