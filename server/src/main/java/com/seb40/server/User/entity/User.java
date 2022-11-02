package com.seb40.server.User.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column( nullable = false, name="user_name")
    private String name;

    @Column( nullable = false, updatable = false, unique = true, name = "user_email")
    private String email;

    @Column(nullable = false, name ="user_password")
    private String password;

//
//    @OneToMany(mappedBy = "user")
//    private List<Question> qestions = new ArrayList<>();


}
