package com.mirera.merchandise.application.service.orders;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mirera.merchandise.application.port.inbound.orders.OrderUseCase;
import com.mirera.merchandise.application.port.inbound.orders.response.OrderItemResDTO;
import com.mirera.merchandise.application.port.inbound.orders.response.OrderPageResDTO;
import com.mirera.merchandise.application.port.inbound.orders.response.OrderResDTO;
import com.mirera.merchandise.application.port.outbound.orders.OrderItemRepository;
import com.mirera.merchandise.application.port.outbound.orders.OrderRepository;
import com.mirera.merchandise.domain.orders.OrdersEntity;

@Service
public class OrderService implements OrderUseCase {
  private final OrderRepository orderRepo;
  private final OrderItemRepository orderItemRepo;

  public OrderService(OrderRepository orderRepo, OrderItemRepository orderItemRepo) {
    this.orderRepo = orderRepo;
    this.orderItemRepo = orderItemRepo;
  }

  @Override
  public OrderPageResDTO getAllOrders(Pageable pageable) {
    Page<OrdersEntity> ordersPage = orderRepo.findAllOrders(pageable);

    if (ordersPage == null || ordersPage.getContent().isEmpty()) {
      throw new IllegalArgumentException("Không có đơn hàng nào.");
    }
    
    List<OrderResDTO> orders = ordersPage.getContent().stream()
      .map(order -> {
        List<OrderItemResDTO> orderItems = orderItemRepo.findByOrderId(order.getId()).stream()
          .map(orderItem -> new OrderItemResDTO(
            orderItem.getId(),
            orderItem.getItem().getId(),
            orderItem.getItem().getItemName(),
            orderItem.getQuantity(),
            orderItem.getItem().getItemPrice()
          ))
          .toList();
        return new OrderResDTO(
          order.getId(),
          order.getUser().getId(),
          order.getOrderDate(),
          orderItems
        );
      })
      .toList();

    return new OrderPageResDTO(
      ordersPage.getNumber(),
      ordersPage.getSize(),
      ordersPage.getTotalPages(),
      ordersPage.getTotalElements(),
      orders
    );
  }

  @Override
  public OrderResDTO getOrderById(int id) {
    OrdersEntity order = orderRepo.findOrderById(id);

    if (order == null) {
      throw new IllegalArgumentException("Đơn hàng không tồn tại.");
    }

    List<OrderItemResDTO> orderItems = orderItemRepo.findByOrderId(order.getId()).stream()
      .map(orderItem -> new OrderItemResDTO(
        orderItem.getId(),
        orderItem.getItem().getId(),
        orderItem.getItem().getItemName(),
        orderItem.getQuantity(),
        orderItem.getItem().getItemPrice()
      ))
      .toList();
      
    return new OrderResDTO(
      order.getId(),
      order.getUser().getId(),
      order.getOrderDate(),
      orderItems
    );
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

  @Override
  public void deleteOrderById(int id) {
    if (orderRepo.findOrderById(id) == null) {
      throw new IllegalArgumentException("Đơn hàng không tồn tại.");
    }
    orderRepo.deleteOrderById(id);
  }
}
