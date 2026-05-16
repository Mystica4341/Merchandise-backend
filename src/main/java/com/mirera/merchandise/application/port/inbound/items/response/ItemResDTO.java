package com.mirera.merchandise.application.port.inbound.items.response;

import java.time.LocalDateTime;
import java.util.List;

public record ItemResDTO(
    int id,
    String item_name,
    String item_description,
    double item_price,
    String item_image_url,
    int stock_quantity,
    String item_color,
    String item_size,
    boolean status,
    List<CategoriesRes> categories,
    LocalDateTime created_at,
    LocalDateTime updated_at
) {
    public record CategoriesRes(
        int id,
        String category_name
    ) {}
}
