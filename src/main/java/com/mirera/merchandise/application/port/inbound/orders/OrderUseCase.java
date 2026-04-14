package com.mirera.merchandise.application.port.inbound.orders;

import com.mirera.merchandise.domain.orders.OrdersEntity;

public interface OrderUseCase {
  void createOrder(OrdersEntity order);

  void updateOrder(OrdersEntity order);
}
