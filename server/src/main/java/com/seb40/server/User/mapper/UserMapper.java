package com.seb40.server.User.mapper;


import com.seb40.server.User.dto.UserLoginDto;
import com.seb40.server.User.dto.UserPostDto;
import com.seb40.server.User.dto.UserResponseDto;
import com.seb40.server.User.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target="userId")
    User userPostDtoUser(UserPostDto userDto);

    User userLoginDtoUser(UserLoginDto userLoginDto);
    UserResponseDto userToUserResponseDto(User user);


}
