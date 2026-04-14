package com.mirera.merchandise.application.port.outbound.users;

import java.util.List;

import com.mirera.merchandise.domain.users.UsersEntity;

public interface UserRepository {
  List<UsersEntity> findAll();

  UsersEntity findUserById(int id);

  UsersEntity findByEmail(String email);

  void saveUser(UsersEntity user);

  void deleteUserById(int id);

  boolean existsByEmail(String email);

  boolean existsByUsername(String username);
}
