package com.mirera.merchandise.application.port.outbound.orders;

import java.util.List;

import com.mirera.merchandise.domain.orders.OrdersEntity;

public interface OrderRepository {
  List<OrdersEntity> findAll();

  OrdersEntity findOrderById(int id);

  void saveOrder(OrdersEntity order);
}