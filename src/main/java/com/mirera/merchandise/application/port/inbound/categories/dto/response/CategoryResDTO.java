package com.mirera.merchandise.application.port.inbound.categories.dto.response;

import java.time.LocalDateTime;

public record CategoryResDTO(
  int id,
  String category_name,
  String description,
  Boolean status,
  LocalDateTime created_at,
  LocalDateTime updated_at
) {}
