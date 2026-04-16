package com.mirera.merchandise.application.port.outbound.orders;

import java.util.List;

import com.mirera.merchandise.domain.orders.OrderItemsEntity;

public interface OrderItemRepository {
  List<OrderItemsEntity> findAll();

  OrderItemsEntity findByOrder_IdAndItem_Id(int orderId, int itemId);

  void saveOrderItem(OrderItemsEntity orderItem);

  void deleteOrderItem(int orderId, int itemId);
}
