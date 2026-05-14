package com.mirera.merchandise.application.port.inbound.users;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Pageable;

import com.mirera.merchandise.application.port.inbound.users.dto.request.UserCreateReqDTO;
import com.mirera.merchandise.application.port.inbound.users.dto.request.UserUpdateReqDTO;
import com.mirera.merchandise.application.port.inbound.users.dto.response.UserPageResDTO;
import com.mirera.merchandise.application.port.inbound.users.dto.response.UserResDTO;

@Configuration
public interface UserUseCase {
  UserPageResDTO getAllUsers(Pageable pageable);

  UserResDTO getUserById(int id);

  void createUser(UserCreateReqDTO user);

  void updateUser(int id, UserUpdateReqDTO user);

  void softDeleteUser(int id);

  void deleteUserById(int id);
}
