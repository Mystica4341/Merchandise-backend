package com.mirera.merchandise.infrastructure.controller.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mirera.merchandise.application.port.inbound.auth.dto.request.LoginReqDTO;
import com.mirera.merchandise.application.port.inbound.auth.dto.request.RegisterReqDTO;
import com.mirera.merchandise.application.port.inbound.auth.dto.response.LoginResDTO;
import com.mirera.merchandise.application.service.auth.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
  private final AuthService authService;

  public AuthController(AuthService authService) {
    this.authService = authService;
  }

  @PostMapping("/login")
  public ResponseEntity<LoginResDTO> login(@RequestBody LoginReqDTO request) {
    try {
      LoginResDTO response = authService.authenticate(request.account(), request.password());
      return ResponseEntity.ok(response);
    } catch (IllegalArgumentException e) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    }
  }
  
  @PostMapping("/register")
  public String registerUser(@RequestBody RegisterReqDTO request) {
    try {
      authService.register(request.email(), request.username(), request.password());
      return "Đăng ký thành công";
    } catch (IllegalArgumentException e) {
      return "Error: " + e.getMessage();
    }
  }
  
}
