package com.mirera.merchandise.application.service;

import com.mirera.merchandise.application.port.inbound.users.RegisterUserUseCase;
import com.mirera.merchandise.application.port.outbound.users.UserRepository;
import com.mirera.merchandise.domain.Users.Users;

public class RegisterUserService implements RegisterUserUseCase {
    private final UserRepository userRepo;

    public RegisterUserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public void registerUser(String email, String username, String password) {
        Users user = new Users(email, username, password);
        if (userRepo.existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("Email already in use");
        }
        if (userRepo.existsByUsername(user.getUsername())) {
            throw new IllegalArgumentException("Username already in use");
        }
        userRepo.saveUser(user);
    }

}
