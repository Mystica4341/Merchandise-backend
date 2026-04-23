package com.mirera.merchandise.application.port.inbound.auth.dto.response;

import java.time.LocalDateTime;

public record StatusCodeResDTO(
  int code, 
  String message, 
  String path, 
  LocalDateTime timestamp
) {}
