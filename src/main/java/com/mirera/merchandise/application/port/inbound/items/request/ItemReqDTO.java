package com.mirera.merchandise.application.port.inbound.items.request;

import java.util.List;

public record ItemReqDTO(
  String itemName,
  String itemDescription,
  double itemPrice,
  String itemImageUrl,
  int stockQuantity,
  String itemColor,
  String itemSize,
  String status,
  List<Integer> categoryIds
) {}
