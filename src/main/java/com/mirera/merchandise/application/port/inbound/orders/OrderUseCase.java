package com.mirera.merchandise.application.port.inbound.orders;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Pageable;

import com.mirera.merchandise.application.port.inbound.orders.response.OrderPageResDTO;
import com.mirera.merchandise.application.port.inbound.orders.response.OrderResDTO;
import com.mirera.merchandise.domain.orders.OrdersEntity;

@Configuration
public interface OrderUseCase {
  OrderPageResDTO getAllOrders(Pageable pageable);

  OrderResDTO getOrderById(int id);

  void createOrder(OrdersEntity order);

  void updateOrder(OrdersEntity order);

  void deleteOrderById(int id);
}
