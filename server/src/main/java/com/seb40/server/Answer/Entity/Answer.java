package com.seb40.server.Answer.Entity;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//@Entity
public class Answer {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long answerId;
    private long questionId;
    private long userId;
    private LocalDateTime answerCreateAt;
    private LocalDateTime answerModified;
    private String answerBody;

    public Answer(long answerId, String answerBody) {
    }
}
