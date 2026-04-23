package com.mirera.merchandise.application.port.inbound.auth.dto.request;

public record RegisterReqDTO(
  String email,
  String username,
  String password
) {}