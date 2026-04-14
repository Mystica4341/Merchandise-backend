package com.mirera.merchandise.infrastructure.repository.orders;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mirera.merchandise.domain.orders.OrdersEntity;

public interface OrderJpaRepository extends JpaRepository<OrdersEntity, Integer> {
  
}
