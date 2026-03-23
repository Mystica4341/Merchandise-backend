package com.mirera.merchandise.application.port.outbound.orders;

import com.mirera.merchandise.domain.Orders.Orders;

public interface OrderRepository {
  void findAll();
  Orders findOrderById(int orderId);
  void saveOrder(Orders order);
}