package com.seb40.server.User.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginDto {

    private String email;

    private String password;

}
