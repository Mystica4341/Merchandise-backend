package com.mirera.merchandise.application.port.inbound.orders;

import com.mirera.merchandise.domain.orders.OrderItemsEntity;

public interface OrderItemUseCase {
  void addOrderItem(OrderItemsEntity orderItem);
   
  void updateOrderItem(OrderItemsEntity orderItem);

  void deleteOrderItem(int orderId, int itemId);
}