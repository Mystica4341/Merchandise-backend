package com.mirera.merchandise.application.port.inbound.users;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Pageable;

import com.mirera.merchandise.application.port.inbound.users.dto.response.UserPageResponseDTO;
import com.mirera.merchandise.domain.users.UsersEntity;

@Configuration
public interface UserUseCase {
  UserPageResponseDTO getAllUsers(Pageable pageable);

  void createUser(UsersEntity user);

  void registerUser(String email, String username, String password);

  void updateUser(UsersEntity user);

  void softDeleteUser(int id);

  void deleteUserById(int id);
}
