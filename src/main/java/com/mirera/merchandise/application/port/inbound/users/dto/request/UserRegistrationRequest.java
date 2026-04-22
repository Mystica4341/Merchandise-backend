package com.mirera.merchandise.application.port.inbound.users.dto.request;

public record UserRegistrationRequest(
  String email,
  String username,
  String password
) {}