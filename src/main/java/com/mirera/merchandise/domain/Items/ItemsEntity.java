package com.mirera.merchandise.domain.items;

import java.util.HashSet;
import java.util.Set;

import com.mirera.merchandise.domain.categories.CategoriesEntity;
import com.mirera.merchandise.domain.entity.BaseEntity;
import com.mirera.merchandise.domain.orders.OrderItemsEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "items")
public class ItemsEntity extends BaseEntity {
  @Column(name = "item_name", nullable = false, unique = true)
  private String itemName;

  @Column(name = "item_description")
  private String itemDescription;

  @Column(name = "item_price")
  private double itemPrice;

  @Column(name = "item_image_url")
  private String itemImageUrl;

  @Column(name = "stock_quantity")
  private int stockQuantity;

  @Column(name = "item_color")
  private String itemColor;

  @Column(name = "item_size")
  private String itemSize;

  @ManyToMany
  @JoinTable(name = "item_categories",
    joinColumns = @JoinColumn(name = "item_id"),
    inverseJoinColumns = @JoinColumn(name = "category_id")
  )
  private Set<CategoriesEntity> categories;

  @OneToMany(mappedBy = "item")
  private Set<OrderItemsEntity> orderItems = new HashSet<>();

  @Column(name = "status", nullable = false)
  private Boolean status;
}
