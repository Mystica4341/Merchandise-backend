package com.mirera.merchandise.infrastructure.controller.users;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mirera.merchandise.application.port.inbound.users.UserUseCase;


@RestController
@RequestMapping("/api/users")
public class UserController {
  private final UserUseCase userUseCase;

  public UserController(UserUseCase userUseCase) {
    this.userUseCase = userUseCase;
  }

  @PostMapping("/register")
  public String registerUser(@RequestBody UserRegistrationRequest request) {
    try {
      userUseCase.registerUser(request.username(), request.email(), request.password());
      return "User registered successfully";
    } catch (IllegalArgumentException e) {
      return "Error: " + e.getMessage();
    }
  }

  public record UserRegistrationRequest(
    String username,
    String email,
    String password
  ) {}
}
