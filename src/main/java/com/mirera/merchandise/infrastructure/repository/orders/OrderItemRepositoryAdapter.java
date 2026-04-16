package com.mirera.merchandise.infrastructure.repository.orders;

import java.util.List;

import com.mirera.merchandise.application.port.outbound.orders.OrderItemRepository;
import com.mirera.merchandise.domain.orders.OrderItemsEntity;


public class OrderItemRepositoryAdapter implements OrderItemRepository {
  private final OrderItemJpaRepository orderItemJpaRepo;

  public OrderItemRepositoryAdapter(OrderItemJpaRepository orderItemJpaRepo) {
    this.orderItemJpaRepo = orderItemJpaRepo;
  }

  @Override
  public List<OrderItemsEntity> findAll() {
    return orderItemJpaRepo.findAll();
  }

  @Override
  public OrderItemsEntity findByOrder_IdAndItem_Id(int orderId, int itemId) {
    return orderItemJpaRepo.findByOrder_IdAndItem_Id(orderId, itemId);
  }

  @Override
  public void saveOrderItem(OrderItemsEntity orderItem) {
    orderItemJpaRepo.save(orderItem);
  }

  @Override
  public void deleteOrderItem(int orderId, int itemId) {
    OrderItemsEntity existingOrderItem = findByOrder_IdAndItem_Id(orderId, itemId);
    if (existingOrderItem != null) {
      orderItemJpaRepo.delete(existingOrderItem);
    }
  }
  
}
