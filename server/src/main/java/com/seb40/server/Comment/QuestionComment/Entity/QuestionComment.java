package com.seb40.server.Comment.QuestionComment.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "questionComment")
public class QuestionComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionCommentId;

    @Column( nullable = false)
    private Long questionId;

    @Column( nullable = false)
    private Long userId;

    @Column( nullable = false)
    private String questionCommentBody;

    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime questionCommentCreateAt  = LocalDateTime.now();


}
