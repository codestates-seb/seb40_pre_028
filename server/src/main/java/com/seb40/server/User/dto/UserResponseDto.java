package com.seb40.server.User.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserResponseDto {

    private long id;

    private String name;
    private String email;

}
