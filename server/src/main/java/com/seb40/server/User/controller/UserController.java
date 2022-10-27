package com.seb40.server.User.controller;

import com.seb40.server.Response.SingleResponseDto;
import com.seb40.server.User.dto.UserLoginDto;
import com.seb40.server.User.dto.UserPostDto;
import com.seb40.server.User.entity.User;
import com.seb40.server.User.mapper.UserMapper;
import com.seb40.server.User.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping("/join")
    public ResponseEntity postUser(@Valid @RequestBody UserPostDto userPostDto){
        User user = userMapper.userPostDtoUser(userPostDto);
        User response = userService.createUser(user);

        return new ResponseEntity<>(
                userMapper.userToUserResponseDto(response),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/login")
    public ResponseEntity getUser(@Valid @RequestBody UserLoginDto userLoginDto){

        User user = userService.findUser(userLoginDto);

        return new ResponseEntity<>(
                new SingleResponseDto<>(userMapper.userToUserResponseDto(user)),
                HttpStatus.OK);
    }


////    @PutMapping("/logout")
//
}
