package com.mirera.merchandise.application.port.outbound.users;

import com.mirera.merchandise.domain.Users.Users;

public interface UserRepository {
  void findAll();
  Users findUserById(int userId);
  void saveUser(Users user);
  void deleteUser(Users user);
  void deleteUserById(int userId);
  boolean existsByEmail(String email);
  boolean existsByUsername(String username);
}
