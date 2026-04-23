package com.mirera.merchandise.infrastructure.controller.users;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mirera.merchandise.application.port.inbound.users.UserUseCase;
import com.mirera.merchandise.application.port.inbound.users.dto.request.UserCreateReqDTO;
import com.mirera.merchandise.application.port.inbound.users.dto.request.UserUpdateReqDTO;
import com.mirera.merchandise.application.port.inbound.users.dto.response.UserPageResDTO;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;



@RestController
@RequestMapping("/api/users")
public class UserController {
  private final UserUseCase userUseCase;

  public UserController(UserUseCase userUseCase) {
    this.userUseCase = userUseCase;
  }

  @GetMapping
  public UserPageResDTO getAllUsers(Pageable pageable) {
    try {
      return userUseCase.getAllUsers(pageable);
    } catch (Exception e) {
      throw new RuntimeException("Error fetching users: " + e.getMessage());
    }
  }

  @PostMapping
  @SecurityRequirement(name = "BearerAuth")
  public String createUser(@RequestBody UserCreateReqDTO user) {
    try {
      userUseCase.createUser(user);
      return "Tạo user thành công";
    } catch (IllegalArgumentException e) {
      return "Error: " + e.getMessage();
    }
  }

  @PutMapping("/{id}")
  @SecurityRequirement(name = "BearerAuth")
  public String updateUser(@PathVariable int id, @RequestBody UserUpdateReqDTO user) {
    try {
      userUseCase.updateUser(id, user);
      return "Cập nhật user thành công";
    } catch (IllegalArgumentException e) {
      return "Error: " + e.getMessage();
    }
  }

  @PutMapping("soft-delete/{id}")
  @SecurityRequirement(name = "BearerAuth")
  public String softDelete(@PathVariable int id) {
    try {
      userUseCase.softDeleteUser(id);
      return "Tài khoản đã bị vô hiệu hóa";
    } catch (IllegalArgumentException e) {
      return "Error: " + e.getMessage();
    }
  }

  @DeleteMapping("hard-delete/{id}")
  @SecurityRequirement(name = "BearerAuth")
  public String deleteUser(@PathVariable int id) {
    try {
      userUseCase.deleteUserById(id);
      return "Xóa user thành công";
    } catch (IllegalArgumentException e) {
      return "Error: " + e.getMessage();
    }
  }
}
