package com.project.sns.service;

import com.project.sns.exception.ErrorCode;
import com.project.sns.exception.SnsApplicationException;
import com.project.sns.model.User;
import com.project.sns.model.entity.UserEntity;
import com.project.sns.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserEntityRepository userEntityRepository;
    // TODO : implement
    public User join(String userName, String password) {

        userEntityRepository.findByUserName(userName).ifPresent(it -> {
            throw new SnsApplicationException(ErrorCode.DUPLICATED_USER_NAME, "");
//            String.format("%s is duplicated, userName")
        });
        //회원가입 진행
        UserEntity userEntity = userEntityRepository.save(UserEntity.of(userName, password));
        return User.fromEntity(userEntity);
    }

    // TODO : implement
    public String login(String userName, String password) {

        UserEntity userEntity = userEntityRepository.findByUserName(userName).orElseThrow(() -> new SnsApplicationException(ErrorCode.DUPLICATED_USER_NAME, ""));

        //비밀번호 체크
        if(!userEntity.getPassword().equals(password)){
            throw new SnsApplicationException(ErrorCode.DUPLICATED_USER_NAME, "");
        }

        //토큰 생성
        return "";
    }
}
