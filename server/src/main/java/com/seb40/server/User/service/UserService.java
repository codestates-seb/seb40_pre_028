package com.seb40.server.User.service;

import com.seb40.server.Exception.BusinessLogicException;
import com.seb40.server.Exception.ExceptionCode;
import com.seb40.server.User.dto.UserLoginDto;
import com.seb40.server.User.entity.User;
import com.seb40.server.User.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User createUser(User user){
        //이메일 등록 확인
        verifyExistsEmail(user.getEmail());

        return userRepository.save(user);
    }

    private void verifyExistsEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);

        if (user.isPresent())
            throw new BusinessLogicException(ExceptionCode.USER_EXISTS);
    }

    public User longinUser( User user) {

        String email = user.getEmail();
        String password = user.getPassword();

        Optional<User> checkLogin = userRepository.findByEmailAndPassword(email, password);

        User loginUser = checkLogin.orElseThrow(()->
                new BusinessLogicException(ExceptionCode.USER_NOT_FOUND));

        return loginUser;

    }


    private User findVerifiedUser(Long userId) {
        Optional<User> optionalUser =
                userRepository.findById(userId);

        //DB에 저장된 user가 없다면 Exception
        User findUser = optionalUser.orElseThrow(() ->
                new BusinessLogicException(ExceptionCode.USER_NOT_FOUND));

        return findUser;

    }



}
