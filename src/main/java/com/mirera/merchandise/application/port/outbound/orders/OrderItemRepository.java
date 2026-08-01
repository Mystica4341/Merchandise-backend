package com.mirera.merchandise.application.port.outbound.orders;

import java.util.List;

import org.springframework.context.annotation.Configuration;

import com.mirera.merchandise.domain.orders.OrderItemsEntity;

@Configuration
public interface OrderItemRepository {
  OrderItemsEntity findByOrder_IdAndItem_Id(int orderId, int itemId);

  List<OrderItemsEntity> findByOrderId(int orderId);

  void saveOrderItem(OrderItemsEntity orderItem);

  void deleteOrderItem(int orderId, int itemId);
}
