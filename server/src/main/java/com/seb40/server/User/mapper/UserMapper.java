package com.seb40.server.User.mapper;


import com.seb40.server.User.dto.UserDto;
import com.seb40.server.User.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserEntity userDto(UserDto userDto);

}
