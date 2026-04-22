package com.mirera.merchandise.domain.categories;

import java.util.HashSet;
import java.util.Set;

import com.mirera.merchandise.domain.entity.BaseEntity;
import com.mirera.merchandise.domain.items.ItemsEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "categories")
public class CategoriesEntity extends BaseEntity {
  @Column(name = "category_name", nullable = false, unique = true)
  private String categoryName;

  @Column(name = "description")
  private String description;

  @ManyToMany(mappedBy = "categories")
  private Set<ItemsEntity> items = new HashSet<>();

  @Column(name = "status", nullable = false)
  private Boolean status;
}
