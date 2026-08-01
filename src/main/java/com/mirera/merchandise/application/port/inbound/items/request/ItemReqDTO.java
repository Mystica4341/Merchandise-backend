package com.mirera.merchandise.application.port.inbound.items.request;

import java.math.BigDecimal;
import java.util.List;

public record ItemReqDTO(
  String itemName,
  String itemDescription,
  BigDecimal itemPrice,
  String itemImageUrl,
  int stockQuantity,
  String itemColor,
  String itemSize,
  String status,
  List<Integer> categoryIds
) {}
