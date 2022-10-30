package com.seb40.server.Quesiton.Entity;

import com.seb40.server.Answer.Dto.AnswerResponseDto;
import com.seb40.server.Answer.Entity.Answer;
import com.seb40.server.Tag.Entity.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Question{
    @Id
    @Column( nullable = false, name="question_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long questionId;

//    @ManyToOne
//    @JoinColumn(name="user_id")
//    private long id;

    @OneToMany(mappedBy = "question", cascade = CascadeType.PERSIST)//추가
    private List<Answer> answers = new ArrayList<>();

//    @OneToMany(mappedBy = "question")
//    private List<Tag> tags = new ArrayList<>();

    //@OneToMany()//질문 코멘트





    private String questionTitle;
    private String questionBody;
    @CreatedDate
    private LocalDateTime questionCreatedAt = LocalDateTime.now();
    @LastModifiedDate
    private LocalDateTime questionModified  = LocalDateTime.now();



}