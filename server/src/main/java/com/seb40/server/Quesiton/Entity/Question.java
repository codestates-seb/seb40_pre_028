package com.seb40.server.Quesiton.Entity;

import com.seb40.server.Answer.Entity.Answer;
import com.seb40.server.Tag.Entity.Tag;
import com.seb40.server.User.entity.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Entity
public class Question{
    @Id
    @Column( nullable = false, name="question_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
    public void setUser(User user){this.user = user;}

    @OneToMany(mappedBy = "question", cascade = CascadeType.PERSIST)//추가
    private List<Answer> answers = new ArrayList<>();

//    @OneToMany(mappedBy = "question")
//    private ArrayList<Tag> tags = new ArrayList<>();


    private int answerNum;

    private long views;


    private String questionTitle;
    private String questionBody;
    @CreatedDate
    private LocalDateTime questionCreatedAt = LocalDateTime.now();
    @LastModifiedDate
    private LocalDateTime questionModified  = LocalDateTime.now();

//    @OneToMany(mappedBy = "question", cascade = CascadeType.PERSIST)
//    private List<QuestionTag> questionTags = new ArrayList<>();



}