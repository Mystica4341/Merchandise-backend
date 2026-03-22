package com.mirera.merchandise.domain.port.inbound.users;

import org.apache.catalina.User;

public interface CreateUserUseCase {
  void createUser(User user);
}
