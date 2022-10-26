package com.seb40.server.User.mapper;

import com.seb40.server.User.dto.UserDto;
import com.seb40.server.User.entity.UserEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-26T18:02:08+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.16.1 (Azul Systems, Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserEntity userDto(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setUser_id( userDto.getUser_id() );
        userEntity.setUser_name( userDto.getUser_name() );
        userEntity.setUser_email( userDto.getUser_email() );
        userEntity.setUser_password( userDto.getUser_password() );

        return userEntity;
    }
}
