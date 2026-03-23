package com.mirera.merchandise.application.service.users;

import com.mirera.merchandise.application.port.inbound.users.UserUseCase;
import com.mirera.merchandise.application.port.outbound.users.UserRepository;
import com.mirera.merchandise.domain.Users.Users;

public class UserService implements UserUseCase {
  private final UserRepository userRepo;

  public UserService(UserRepository userRepo) {
    this.userRepo = userRepo;
  }

  @Override
  public void createUser(Users user) {
    if (userRepo.existsByEmail(user.getEmail())) {
      throw new IllegalArgumentException("Email này đã được đăng ký");
    }
    if (userRepo.existsByUsername(user.getUsername())) {
      throw new IllegalArgumentException("Username này đã được sử dụng");
    }
    userRepo.saveUser(user);
  }

  @Override
    public void registerUser(String email, String username, String password) {
        Users user = new Users(email, username, password);
        if (userRepo.existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("Email này đã được đăng ký");
        }
        if (userRepo.existsByUsername(user.getUsername())) {
            throw new IllegalArgumentException("Username này đã được sử dụng");
        }
        userRepo.saveUser(user);
    }

  @Override
  public void updateUser(Users user) {
    if (!userRepo.existsByEmail(user.getEmail())) {
      throw new IllegalArgumentException("User không tồn tại");
    }
    userRepo.saveUser(user);
  }

  @Override
  public void deleteUser(Users user) {
    if (!userRepo.existsByEmail(user.getEmail())) {
      throw new IllegalArgumentException("User không tồn tại");
    }
    userRepo.deleteUser(user);
  }

  @Override
  public void deleteUserById(int userId) {
    Users user = userRepo.findUserById(userId);
    if (user == null) {
      throw new IllegalArgumentException("User không tồn tại");
    }
    userRepo.deleteUserById(userId);
  }
}