package com.mirera.merchandise.application.port.inbound.orders.response;

import java.util.List;

public record OrderPageResDTO(
  int page,
  int size,
  int total_pages,
  long total_elements,
  List<OrderResDTO> orders
) {}
