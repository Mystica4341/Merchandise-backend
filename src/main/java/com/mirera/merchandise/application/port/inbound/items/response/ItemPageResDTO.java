package com.mirera.merchandise.application.port.inbound.items.response;

import java.util.List;

public record ItemPageResDTO(
  int page,
  int size,
  int total_pages,
  long total_elements,
  List<ItemResDTO> categories
) {}
