package com.seb40.server.User.mapper;

import com.seb40.server.User.dto.UserLoginDto;
import com.seb40.server.User.dto.UserPostDto;
import com.seb40.server.User.dto.UserResponseDto;
import com.seb40.server.User.entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-02T11:20:14+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.16.1 (Azul Systems, Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User userPostDtoUser(UserPostDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setUserId( userDto.getUserId() );
        user.setName( userDto.getName() );
        user.setEmail( userDto.getEmail() );
        user.setPassword( userDto.getPassword() );

        return user;
    }

    @Override
    public User userLoginDtoUser(UserLoginDto userLoginDto) {
        if ( userLoginDto == null ) {
            return null;
        }

        User user = new User();

        user.setEmail( userLoginDto.getEmail() );
        user.setPassword( userLoginDto.getPassword() );

        return user;
    }

    @Override
    public UserResponseDto userToUserResponseDto(User user) {
        if ( user == null ) {
            return null;
        }

        long userId = 0L;
        String name = null;
        String email = null;

        if ( user.getUserId() != null ) {
            userId = user.getUserId();
        }
        name = user.getName();
        email = user.getEmail();

        UserResponseDto userResponseDto = new UserResponseDto( userId, name, email );

        return userResponseDto;
    }
}
