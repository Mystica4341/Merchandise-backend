package com.mirera.merchandise.application.port.inbound.users.dto.request;

public record UserCreateReqDTO(
  String email,
  String username,
  String full_name,
  String password,
  String role,
  String address,
  String phone_number
) {}
