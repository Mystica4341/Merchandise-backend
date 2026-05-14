package com.mirera.merchandise.application.port.inbound.categories.dto.response;

import java.util.List;

public record CategoryPageResDTO(
  int page,
  int size,
  int total_pages,
  long total_elements,
  List<CategoryResDTO> categories
) {}