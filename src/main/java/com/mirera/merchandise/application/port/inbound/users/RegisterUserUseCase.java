package com.mirera.merchandise.application.port.inbound.users;

public interface RegisterUserUseCase {
  void registerUser(String email, String username, String password);
}
