package com.mirera.merchandise.domain.categories;

import com.mirera.merchandise.domain.entity.BaseEntity;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoriesEntity extends BaseEntity {
  @Column(name = "category_name", nullable = false, unique = true)
  private String categoryName;
}
