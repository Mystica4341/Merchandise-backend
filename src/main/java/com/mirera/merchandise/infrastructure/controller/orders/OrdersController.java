package com.mirera.merchandise.infrastructure.controller.orders;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mirera.merchandise.application.port.inbound.orders.OrderUseCase;
import com.mirera.merchandise.application.port.inbound.orders.response.OrderPageResDTO;
import com.mirera.merchandise.application.port.inbound.orders.response.OrderResDTO;


@RestController
@RequestMapping("/api/orders")
public class OrdersController {
  private final OrderUseCase orderUseCase;

  public OrdersController(OrderUseCase orderUseCase) {
    this.orderUseCase = orderUseCase;
  }

  @GetMapping
  public OrderPageResDTO getAllOrders(Pageable pageable) {
    try {
      return orderUseCase.getAllOrders(pageable);
    } catch (Exception e) {
      throw new RuntimeException("Error fetching orders: " + e.getMessage());
    }
  }
  
  @GetMapping("/{id}")
  public OrderResDTO getOrderById(@PathVariable int id) {
    try {
      return orderUseCase.getOrderById(id);
    } catch (Exception e) {
      throw new RuntimeException("Error fetching order: " + e.getMessage());
    }
  }
}
