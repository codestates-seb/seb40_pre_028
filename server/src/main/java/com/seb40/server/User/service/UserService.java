package com.seb40.server.User.service;


import com.seb40.server.Exception.BusinessLogicException;
import com.seb40.server.Exception.ExceptionCode;
import com.seb40.server.User.entity.UserEntity;
import com.seb40.server.User.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserEntity createUser(UserEntity userEntity){
        //이메일 중복 확인
        verifyExistsEmail(userEntity.getEmail());

        return userRepository.save(userEntity);
    }

    private void verifyExistsEmail(String email) {
        Optional<UserEntity> user = userRepository.findByEmail(email);

        if (user.isPresent())
            throw new BusinessLogicException(ExceptionCode.USER_EXISTS);
    }


}
