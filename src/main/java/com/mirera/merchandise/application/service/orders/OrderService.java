package com.mirera.merchandise.application.service.orders;

import com.mirera.merchandise.application.port.inbound.orders.OrderUseCase;
import com.mirera.merchandise.application.port.outbound.orders.OrderRepository;
import com.mirera.merchandise.domain.orders.OrdersEntity;

public class OrderService implements OrderUseCase {
  private final OrderRepository orderRepo;

  public OrderService(OrderRepository orderRepo) {
    this.orderRepo = orderRepo;
  }

  @Override
  public void createOrder(OrdersEntity order) {
    orderRepo.saveOrder(order);
  }

  @Override
  public void updateOrder(OrdersEntity order) {
    if (orderRepo.findOrderById(order.getId()) == null) {
      throw new IllegalArgumentException("Đơn hàng không tồn tại.");
    }
    orderRepo.saveOrder(order);
  }
}
