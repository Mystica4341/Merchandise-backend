package com.mirera.merchandise.application.service.orders;

import com.mirera.merchandise.application.port.inbound.orders.OrderItemUseCase;
import com.mirera.merchandise.application.port.outbound.orders.OrderItemRepository;
import com.mirera.merchandise.domain.orders.OrderItemsEntity;

public class OrderItemService implements OrderItemUseCase{
  private final OrderItemRepository orderItemRepo;

  public OrderItemService(OrderItemRepository orderItemRepo) {
    this.orderItemRepo = orderItemRepo;
  }

  @Override
  public void addOrderItem(OrderItemsEntity orderItem) {
    orderItemRepo.saveOrderItem(orderItem);
  }

  @Override
  public void updateOrderItem(OrderItemsEntity orderItem) {
    int orderId = extractOrderId(orderItem);
    int itemId = extractItemId(orderItem);

    if (orderItemRepo.findByOrder_IdAndItem_Id(orderId, itemId) == null) {
      throw new IllegalArgumentException("Mục đơn hàng không tồn tại.");
    }
    orderItemRepo.saveOrderItem(orderItem);
  }

  @Override
  public void deleteOrderItem(int orderId, int itemId) {
    if (orderItemRepo.findByOrder_IdAndItem_Id(orderId, itemId) == null) {
      throw new IllegalArgumentException("Mục đơn hàng không tồn tại.");
    }
    orderItemRepo.deleteOrderItem(orderId, itemId);
  }

  private int extractOrderId(OrderItemsEntity orderItem) {
    if (orderItem == null || orderItem.getOrder() == null) {
      throw new IllegalArgumentException("Thiếu thông tin order trong mục đơn hàng.");
    }
    return orderItem.getOrder().getId();
  }

  private int extractItemId(OrderItemsEntity orderItem) {
    if (orderItem == null || orderItem.getItem() == null) {
      throw new IllegalArgumentException("Thiếu thông tin item trong mục đơn hàng.");
    }
    return orderItem.getItem().getId();
  }
}
