package com.mirera.merchandise.domain.model;

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

  public Integer getitemDetailsId() {
    return itemDetailsId;
  }

  public Items getitemId() {
    return itemId;
  }

  public Integer getsize() {
    return size;
  }

  public double getprice() {
    return price;
  }

  public String getcolor() {
    return color;
  }

  public Integer getstock() {
    return stock;
  }

  public String getimageUrl() {
    return imageUrl;
  }
}
