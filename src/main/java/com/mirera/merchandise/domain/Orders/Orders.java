package com.mirera.merchandise.domain.orders;

import com.mirera.merchandise.domain.users.Users;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class Orders {
  private Integer orderId;
  private Users userId;
  private Integer totalAmount;
  private String orderDate;

  public static enum OrderStatus {
    PENDING("Pending"),
    PAID("Paid"),
    SHIPPED("Shipped"),
    DELIVERED("Delivered"),
    CANCELLED("Cancelled");

    private final String displayName;

    OrderStatus(String displayName) {
      this.displayName = displayName;
    }

    @Override
    public String toString() {
      return displayName;
    }
  }

  private OrderStatus status = OrderStatus.PENDING;
  private String paymentMethod;
  private String shippingAddress;

  public Orders(Integer orderId, Users userId, Integer totalAmount, String orderDate, String status,
      String paymentMethod, String shippingAddress) {
    this.orderId = orderId;
    this.userId = userId;
    this.totalAmount = totalAmount;
    this.orderDate = orderDate;
    this.status = (status == null) ? OrderStatus.PENDING : OrderStatus.valueOf(status.trim().toUpperCase());
    this.paymentMethod = paymentMethod;
    this.shippingAddress = shippingAddress;
  }
}
