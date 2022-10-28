package com.seb40.server.User.mapper;

import com.seb40.server.User.dto.UserPostDto;
import com.seb40.server.User.dto.UserResponseDto;
import com.seb40.server.User.entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-28T10:06:54+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.16.1 (Azul Systems, Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User userPostDtoUser(UserPostDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDto.getId() );
        user.setName( userDto.getName() );
        user.setEmail( userDto.getEmail() );
        user.setPassword( userDto.getPassword() );

        return user;
    }

    @Override
    public UserResponseDto userToUserResponseDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserResponseDto userResponseDto = new UserResponseDto();

        return userResponseDto;
    }
}
