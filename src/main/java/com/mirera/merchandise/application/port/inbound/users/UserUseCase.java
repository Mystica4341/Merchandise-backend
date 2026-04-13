package com.mirera.merchandise.application.port.inbound.users;

import com.mirera.merchandise.domain.users.Users;

public interface UserUseCase {
  void createUser(Users user);

  void registerUser(String email, String username, String password);

  void updateUser(Users user);

  void deleteUser(Users user);

  void deleteUserById(int userId);
}
