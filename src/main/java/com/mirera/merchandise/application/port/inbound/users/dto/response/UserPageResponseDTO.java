package com.mirera.merchandise.application.port.inbound.users.dto.response;

import java.util.List;

public record UserPageResponseDTO(
  int page,
  int size,
  int total_pages,
  long total_elements,
  List<UserResponseDTO> users
) {}