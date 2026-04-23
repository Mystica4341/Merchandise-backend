package com.mirera.merchandise.application.port.inbound.users.dto.response;

import java.util.List;

public record UserPageResDTO(
  int page,
  int size,
  int total_pages,
  long total_elements,
  List<UserResDTO> users
) {}