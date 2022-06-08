package com.azadi.service.impl;

import com.azadi.config.security.JwtTokenUtil;
import com.azadi.controller.UserController;
import com.azadi.model.entity.RoleEntity;
import com.azadi.model.entity.UserEntity;
import com.azadi.repository.RoleRepository;
import com.azadi.repository.UserRepository;
import com.azadi.service.api.UserApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public  class UserService implements UserApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    public Optional<String> signin(String username, String password) {
        Optional<String> token = Optional.empty();
        Optional<UserEntity> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            try {
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
                token = Optional.of(jwtTokenUtil.createToken(username, user.get().getRoles()));
            } catch (AuthenticationException e){
                LOGGER.info("Log in failed for user {}", username);
            }
        }
        return token;
    }

    @Override
    public Optional<UserEntity> signup(String username, String password, String firstName, String lastName) {

        if (!userRepository.findByUsername(username).isPresent()) {
            Optional<RoleEntity> role = roleRepository.findByRoleName("ROLE_CSR");
            return Optional.of(userRepository.save
                    (new UserEntity(username,
                            passwordEncoder.encode(password),
                            role.get(),
                            firstName,
                            lastName)));
        }
        return Optional.empty();

}

    public List<UserEntity> getAll() {
        return userRepository.findAll();
    }

}
