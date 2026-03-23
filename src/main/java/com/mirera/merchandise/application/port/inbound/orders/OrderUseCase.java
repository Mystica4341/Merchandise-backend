package com.mirera.merchandise.application.port.inbound.orders;

import com.mirera.merchandise.domain.Orders.Orders;

public interface OrderUseCase {
  void createOrder(Orders order);
  void updateOrder(Orders order);
}
