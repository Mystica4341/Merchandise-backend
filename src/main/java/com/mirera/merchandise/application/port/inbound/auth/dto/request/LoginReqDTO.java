package com.mirera.merchandise.application.port.inbound.auth.dto.request;

public record LoginReqDTO(
  String account,
  String password
) {}
