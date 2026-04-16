package com.mirera.merchandise.infrastructure.repository.orders;

import java.util.List;

import com.mirera.merchandise.application.port.outbound.orders.OrderRepository;
import com.mirera.merchandise.domain.orders.OrdersEntity;

public class OrderRepositoryAdapter implements OrderRepository {
  private final OrderJpaRepository orderJpaRepository;

  public OrderRepositoryAdapter(OrderJpaRepository orderJpaRepository) {
    this.orderJpaRepository = orderJpaRepository;
  }

  @Override
  public List<OrdersEntity> findAll() {
    return orderJpaRepository.findAll();
  }

  @Override
  public OrdersEntity findOrderById(int id) {
    return orderJpaRepository.findById(id).orElse(null);
  }

  @Override
  public void saveOrder(OrdersEntity order) {
    orderJpaRepository.save(order);
  }
}
