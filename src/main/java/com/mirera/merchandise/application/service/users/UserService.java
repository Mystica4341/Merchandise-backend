package com.mirera.merchandise.application.service.users;

import org.springframework.stereotype.Service;

import com.mirera.merchandise.application.port.inbound.users.UserUseCase;
import com.mirera.merchandise.application.port.outbound.users.UserRepository;
import com.mirera.merchandise.domain.users.UsersEntity;

@Service
public class UserService implements UserUseCase {
  private final UserRepository userRepo;

  public UserService(UserRepository userRepo) {
    this.userRepo = userRepo;
  }

  @Override
  public void createUser(UsersEntity user) {
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
    UsersEntity user = new UsersEntity(email, username, password);
    if (userRepo.existsByEmail(user.getEmail())) {
      throw new IllegalArgumentException("Email này đã được đăng ký");
    }
    if (userRepo.existsByUsername(user.getUsername())) {
      throw new IllegalArgumentException("Username này đã được sử dụng");
    }
    userRepo.saveUser(user);
  }

  @Override
  public void updateUser(UsersEntity user) {
    if (userRepo.findUserById(user.getId()) == null) {
      throw new IllegalArgumentException("User không tồn tại");
    }
    userRepo.saveUser(user);
  }

  @Override
  public void softDeleteUser(int id) {
    UsersEntity user = userRepo.findUserById(id);
    if (user == null) {
      throw new IllegalArgumentException("User không tồn tại");
    }
    if (user.getStatus() == true) {
      user.setStatus(false);
    } else user.setStatus(true);
    userRepo.saveUser(user);
  }

  @Override
  public void deleteUserById(int id) {
    UsersEntity user = userRepo.findUserById(id);
    if (user == null) {
      throw new IllegalArgumentException("User không tồn tại");
    }
    userRepo.deleteUserById(id);
  }

}