package com.mirera.merchandise.domain.items;

import com.mirera.merchandise.domain.categories.Categories;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class Items {
  private Integer itemId;
  private Categories categoryId;
  private String itemName;
  private String description;

  public Items(Integer itemId, Categories categoryId, String itemName, String description) {
    this.itemId = itemId;
    this.categoryId = categoryId;
    this.itemName = itemName;
    this.description = description;
  }
}
