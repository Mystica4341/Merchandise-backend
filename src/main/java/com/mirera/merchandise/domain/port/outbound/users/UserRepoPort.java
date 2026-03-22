package com.mirera.merchandise.domain.port.outbound.users;

import com.mirera.merchandise.domain.model.Users;

public interface UserRepoPort {
  void saveUser(Users user);

  Users findUserById(String userId);

  boolean existsByEmail(String email);

  boolean existsByUsername(String username);
}
