package com.mirera.merchandise.application.port.inbound.users.dto.response;

import java.time.LocalDateTime;

public record UserResponseDTO(
  int id,
  String email,
  String username,
  String full_name,
  String phone_number,
  String address,
  boolean status,
  LocalDateTime created_at,
  LocalDateTime updated_at
){}
