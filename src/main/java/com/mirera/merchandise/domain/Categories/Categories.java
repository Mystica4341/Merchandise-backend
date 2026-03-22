package com.mirera.merchandise.domain.Categories;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class Categories {
  private Integer categoryId;
  private String categoryName;
  private String description;

  public Categories(Integer categoryId, String categoryName, String description) {
    this.categoryId = categoryId;
    this.categoryName = categoryName;
    this.description = description;
  }
}
