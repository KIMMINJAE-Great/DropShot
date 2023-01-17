package com.dropshot.backend.security.services;

import com.dropshot.backend.models.User;
import com.dropshot.backend.payload.request.SignupRequest;

public class UserServiceImpl implements UserService{
    @Override
    public User join(SignupRequest dto) {

        User user = (User)dtoToEntity(dto);

        return user;
    }
}
