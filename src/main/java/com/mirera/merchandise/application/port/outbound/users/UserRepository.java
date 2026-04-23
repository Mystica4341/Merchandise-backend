package com.mirera.merchandise.application.port.outbound.users;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mirera.merchandise.domain.users.UsersEntity;

@Configuration
public interface UserRepository {
  Page<UsersEntity> findAllUsers(Pageable pageable);

  UsersEntity findUserById(int id);

  UsersEntity findByEmail(String email);

  UsersEntity findByUsername(String username);

  void saveUser(UsersEntity user);

  void deleteUserById(int id);

  boolean existsByEmail(String email);

  boolean existsByUsername(String username);
}
