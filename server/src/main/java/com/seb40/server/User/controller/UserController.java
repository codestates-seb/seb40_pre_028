package com.seb40.server.User.controller;

import com.seb40.server.User.dto.UserPostDto;
import com.seb40.server.User.entity.User;
import com.seb40.server.User.mapper.UserMapper;
import com.seb40.server.User.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
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


//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public



//    @PutMapping("/logout")

}
