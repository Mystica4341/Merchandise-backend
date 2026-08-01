package com.mirera.merchandise.application.port.inbound.orders.response;

import java.math.BigDecimal;

public record OrderItemResDTO(
  int orderItemId,
  int itemId,      
  String itemName,
  int quantity,
  BigDecimal price 
) {}
