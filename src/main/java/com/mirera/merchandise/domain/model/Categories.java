package com.mirera.merchandise.domain.model;

public class Categories {
  private Integer categoryId;
  private String categoryName;
  private String description;

  public Categories(Integer categoryId, String categoryName, String description) {
    this.categoryId = categoryId;
    this.categoryName = categoryName;
    this.description = description;
  }

  public Integer getcategoryId() {
    return categoryId;
  }

  public String getcategoryName() {
    return categoryName;
  }

  public String getdescription() {
    return description;
  }
}
