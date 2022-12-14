package com.seb40.server.User.controller;

import com.seb40.server.User.dto.UserLoginDto;
import com.seb40.server.User.dto.UserPostDto;
import com.seb40.server.User.entity.User;
import com.seb40.server.User.mapper.UserMapper;
import com.seb40.server.User.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/user")
@AllArgsConstructor
@Slf4j
public class UserController {

    public final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping("/join")
    public ResponseEntity postUser( @RequestBody UserPostDto userPostDto){
        User user = userMapper.userPostDtoUser(userPostDto);
        User response = userService.createUser(user);

        return new ResponseEntity<>(
                userMapper.userToUserResponseDto(response),
                HttpStatus.CREATED
        );

    }

    @PostMapping("/login")
    public ResponseEntity<Object> loginUser(@RequestBody UserLoginDto userLoginDto) {
        User user = userMapper.userLoginDtoUser(userLoginDto);
        User response = userService.longinUser(user);

        return new ResponseEntity<>(userMapper.userToUserResponseDto(response), HttpStatus.OK);
    }

    @PostMapping("/logout")
    public ResponseEntity<Object> logoutUser() {
        return new ResponseEntity<>("", HttpStatus.OK);
    }


}
