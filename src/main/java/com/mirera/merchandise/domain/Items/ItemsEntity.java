package com.mirera.merchandise.domain.items;

import com.mirera.merchandise.domain.categories.CategoriesEntity;
import com.mirera.merchandise.domain.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemsEntity extends BaseEntity {
  @Column(name = "item_name", nullable = false, unique = true)
  private String itemName;

  @Column(name = "item_description", nullable = false)
  private String itemDescription;

  @Column(name = "item_price", nullable = false)
  private double itemPrice;

  @Column(name = "category_id", nullable = false)
  @OneToOne(mappedBy = "category")
  private CategoriesEntity category;

}
