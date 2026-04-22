package com.mirera.merchandise.domain.orders;

import java.util.Set;

import com.mirera.merchandise.domain.entity.BaseEntity;
import com.mirera.merchandise.domain.users.UsersEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "orders")
public class OrdersEntity extends BaseEntity {
  @Column(name = "order_date", nullable = false, unique = true)
  private String orderDate;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  private UsersEntity user;

  @OneToMany(mappedBy = "order")
  private Set<OrderItemsEntity> orderItems;
}
