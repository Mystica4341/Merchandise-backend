package com.mirera.merchandise.domain.Orders;

import com.mirera.merchandise.domain.Items.Items;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
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

}
