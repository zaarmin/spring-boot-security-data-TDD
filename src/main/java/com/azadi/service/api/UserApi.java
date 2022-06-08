package com.azadi.service.api;

import com.azadi.model.entity.UserEntity;
import org.springframework.security.core.Authentication;

import java.util.List;
import java.util.Optional;

public interface UserApi {
    public  Optional<String> signin(String username, String password);

    public Optional<UserEntity> signup(String username, String password, String firstName, String lastName) ;

    List<UserEntity> getAll();
}
