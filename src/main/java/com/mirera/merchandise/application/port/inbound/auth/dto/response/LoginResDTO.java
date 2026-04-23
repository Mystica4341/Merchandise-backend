package com.mirera.merchandise.application.port.inbound.auth.dto.response;

public record LoginResDTO(
  int id,
  String email,
  String username,
  String role,
  String token
) {}
