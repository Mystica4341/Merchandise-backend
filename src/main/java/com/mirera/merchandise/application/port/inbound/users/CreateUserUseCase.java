package com.mirera.merchandise.application.port.inbound.users;

import com.mirera.merchandise.domain.Users.Users;

public interface CreateUserUseCase {
  void createUser(Users user);
}
