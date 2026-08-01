package com.mirera.merchandise.application.port.inbound.orders.response;

import java.time.LocalDateTime;
import java.util.List;

public record OrderResDTO(
  int id,
  int userId,
  LocalDateTime orderDate,
  List<OrderItemResDTO> orderItems
) {}
