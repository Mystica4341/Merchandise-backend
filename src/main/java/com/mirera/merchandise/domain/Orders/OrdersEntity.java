package com.mirera.merchandise.domain.orders;

import com.mirera.merchandise.domain.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrdersEntity extends BaseEntity {
  @Column(name = "order_date", nullable = false, unique = true)
  private String orderDate;

  @Column(name = "user_id", nullable = false)
  @OneToOne(mappedBy = "userId")
  private int userId;
}
