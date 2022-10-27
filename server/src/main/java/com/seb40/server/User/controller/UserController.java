package com.seb40.server.User.controller;

import com.seb40.server.User.entity.UserEntity;
import com.seb40.server.User.mapper.UserMapper;
import com.seb40.server.User.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

//    @PostMapping("/join")
//    public UserEntity
//
//
//
//    @PostMapping("/login")
//
//    @PutMapping("/logout")

}
