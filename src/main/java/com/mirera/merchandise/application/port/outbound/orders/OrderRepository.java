package com.mirera.merchandise.application.port.outbound.orders;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mirera.merchandise.domain.orders.OrdersEntity;

@Configuration
public interface OrderRepository {
  Page<OrdersEntity> findAllOrders(Pageable pageable);

  OrdersEntity findOrderById(int id);

  void saveOrder(OrdersEntity order);

  void deleteOrderById(int id);
}