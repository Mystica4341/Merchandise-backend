package com.mirera.merchandise.application.service;

import com.mirera.merchandise.application.port.inbound.users.CreateUserUseCase;
import com.mirera.merchandise.application.port.outbound.users.UserRepository;
import com.mirera.merchandise.domain.Users.Users;

public class CreateUserService implements CreateUserUseCase {
  private final UserRepository userRepo;

  public CreateUserService(UserRepository userRepo) {
    this.userRepo = userRepo;
  }

  @Override
  public void createUser(Users user) {
    if (userRepo.existsByEmail(user.getEmail())) {
      throw new IllegalArgumentException("Email already in use");
    }
    if (userRepo.existsByUsername(user.getUsername())) {
      throw new IllegalArgumentException("Username already in use");
    }
    userRepo.saveUser(user);
  }
}