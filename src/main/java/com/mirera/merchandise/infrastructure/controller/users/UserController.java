package com.mirera.merchandise.infrastructure.controller.users;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mirera.merchandise.application.port.inbound.users.UserUseCase;
import com.mirera.merchandise.application.port.inbound.users.dto.request.UserRegistrationRequest;
import com.mirera.merchandise.application.port.inbound.users.dto.response.UserPageResponseDTO;
import com.mirera.merchandise.domain.users.UsersEntity;


@RestController
@RequestMapping("/api/users")
public class UserController {
  private final UserUseCase userUseCase;

  public UserController(UserUseCase userUseCase) {
    this.userUseCase = userUseCase;
  }

  @GetMapping
  public UserPageResponseDTO getAllUsers(Pageable pageable) {
    try {
      return userUseCase.getAllUsers(pageable);
    } catch (Exception e) {
      throw new RuntimeException("Error fetching users: " + e.getMessage());
    }
  }

  @PostMapping
  public String createUser(@RequestBody UsersEntity user) {
    try {
      userUseCase.createUser(user);
      return "User created successfully";
    } catch (IllegalArgumentException e) {
      return "Error: " + e.getMessage();
    }
  }

  @PostMapping("/register")
  public String registerUser(@RequestBody UserRegistrationRequest request) {
    try {
      userUseCase.registerUser(request.email(), request.username(), request.password());
      return "User registered successfully";
    } catch (IllegalArgumentException e) {
      return "Error: " + e.getMessage();
    }
  }

  @GetMapping("/test")
  public String testUser () {
    return "User controller is working!";
  }
}
