package com.mirera.merchandise.application.port.inbound.categories.dto.request;

public record CategoryUpdateReqDTO(
  String categoryName,
  String description
) {}