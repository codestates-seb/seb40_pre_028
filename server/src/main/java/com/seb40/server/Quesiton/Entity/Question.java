package com.seb40.server.Quesiton.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Question{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long questionId;
    private String questionTitle;
    private String questionBody;
    @CreatedDate
    private LocalDateTime questionCreatedAt = LocalDateTime.now();
    @LastModifiedDate
    private LocalDateTime questionModified  = LocalDateTime.now();

}