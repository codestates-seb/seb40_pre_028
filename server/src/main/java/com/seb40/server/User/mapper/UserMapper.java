package com.seb40.server.User.mapper;


import com.seb40.server.User.dto.UserPostDto;
import com.seb40.server.User.dto.UserResponseDto;
import com.seb40.server.User.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User userPostDtoUser(UserPostDto userDto);
    UserResponseDto userToUserResponseDto(User user);


}
