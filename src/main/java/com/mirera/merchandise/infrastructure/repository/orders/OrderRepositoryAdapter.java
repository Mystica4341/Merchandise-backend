package com.mirera.merchandise.infrastructure.repository.orders;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.mirera.merchandise.application.port.outbound.orders.OrderRepository;
import com.mirera.merchandise.domain.orders.OrdersEntity;

@Repository
public class OrderRepositoryAdapter implements OrderRepository {
  private final OrderJpaRepository orderJpaRepository;

  public OrderRepositoryAdapter(OrderJpaRepository orderJpaRepository) {
    this.orderJpaRepository = orderJpaRepository;
  }

  @Override
  public Page<OrdersEntity> findAllOrders(Pageable pageable) {
    return orderJpaRepository.findAll(pageable);
  }

  @Override
  public OrdersEntity findOrderById(int id) {
    return orderJpaRepository.findById(id).orElse(null);
  }

  @Override
  public void saveOrder(OrdersEntity order) {
    orderJpaRepository.save(order);
  }

  @Override
  public void deleteOrderById(int id) {
    orderJpaRepository.deleteById(id);
  }
}
