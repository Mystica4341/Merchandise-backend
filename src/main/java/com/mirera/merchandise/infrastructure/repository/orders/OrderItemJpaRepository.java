package com.mirera.merchandise.infrastructure.repository.orders;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mirera.merchandise.domain.orders.OrderItemsEntity;

public interface OrderItemJpaRepository extends JpaRepository<OrderItemsEntity, Integer> {
  OrderItemsEntity findByOrder_IdAndItem_Id(int orderId, int itemId);

  void deleteByOrder_IdAndItem_Id(int orderId, int itemId);
}