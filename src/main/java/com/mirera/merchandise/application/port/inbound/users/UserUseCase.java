package com.mirera.merchandise.application.port.inbound.users;

import org.springframework.context.annotation.Configuration;

import com.mirera.merchandise.domain.users.UsersEntity;

@Configuration
public interface UserUseCase {
  void createUser(UsersEntity user);

  void registerUser(String email, String username, String password);

  void updateUser(UsersEntity user);

  void softDeleteUser(int id);

  void deleteUserById(int id);
}
