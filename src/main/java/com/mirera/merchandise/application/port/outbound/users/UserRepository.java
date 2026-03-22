package com.mirera.merchandise.application.port.outbound.users;

import com.mirera.merchandise.domain.Users.Users;

public interface UserRepository {
  void saveUser(Users user);

  void deleteUser(Users user);
  
  void deleteUserById(int userId);

  Users findUserById(String userId);

  boolean existsByEmail(String email);

  boolean existsByUsername(String username);

}
