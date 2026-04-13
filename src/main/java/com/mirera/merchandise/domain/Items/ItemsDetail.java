package com.mirera.merchandise.domain.items;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class ItemsDetail {
  private Integer itemDetailsId;
  private Items itemId;
  private Integer size;
  private double price;
  private String color;
  private Integer stock;
  private String imageUrl;

  public ItemsDetail(Integer itemDetailsId, Items itemId, Integer size, double price, String color, Integer stock,
      String imageUrl) {
    this.itemDetailsId = itemDetailsId;
    this.itemId = itemId;
    this.size = size;
    this.price = price;
    this.color = color;
    this.stock = stock;
    this.imageUrl = imageUrl;
  }
}
