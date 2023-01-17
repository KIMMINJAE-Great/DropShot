package com.dropshot.backend.security.services;

import com.dropshot.backend.models.User;
import com.dropshot.backend.payload.request.SignupRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface UserService {

    User join(SignupRequest dto);
//    String login(Member member);

    default User dtoToEntity(SignupRequest dto) {
        User member = User.builder()
                .username(dto.getUsername())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .nickname(dto.getNickname())
                .birthday(dto.getBirthday())
                .build();
        return member;
    }
}
