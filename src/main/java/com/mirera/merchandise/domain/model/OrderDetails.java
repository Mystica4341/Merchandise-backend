package com.mirera.merchandise.domain.model;

public class OrderDetails {
  private Integer orderDetailsId;
  private Orders orderId;
  private Items itemId;
  private Integer quantity;
  private Integer price;

  public OrderDetails(Integer orderDetailsId, Orders orderId, Items itemId, Integer quantity, Integer price) {
    this.orderDetailsId = orderDetailsId;
    this.orderId = orderId;
    this.itemId = itemId;
    this.quantity = quantity;
    this.price = price;
  }

  public Integer getOrderDetailsId() {
    return orderDetailsId;
  }

  public Orders getOrderId() {
    return orderId;
  }

  public Items getItemId() {
    return itemId;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public Integer getPrice() {
    return price;
  }
}
