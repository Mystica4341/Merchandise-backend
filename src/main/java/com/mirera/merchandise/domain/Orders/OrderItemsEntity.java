package com.mirera.merchandise.domain.orders;

import com.mirera.merchandise.domain.entity.BaseEntity;
import com.mirera.merchandise.domain.items.ItemsEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(
  name = "order_items", 
  uniqueConstraints = {@UniqueConstraint(columnNames = {"order_id", "item_id"})}
)
public class OrderItemsEntity extends BaseEntity {
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "order_id", nullable = false)
  private OrdersEntity order;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "item_id", nullable = false)
  private ItemsEntity item;

  @Column(name = "quantity", nullable = false)
  private int quantity;

  @Column(name = "total_price", nullable = false)
  private double totalPrice;
}
