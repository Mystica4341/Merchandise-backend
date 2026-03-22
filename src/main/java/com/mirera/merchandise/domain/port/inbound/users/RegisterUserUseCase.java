package com.mirera.merchandise.domain.port.inbound.users;

public interface RegisterUserUseCase {
  void registerUser(String email, String username, String password);
}
