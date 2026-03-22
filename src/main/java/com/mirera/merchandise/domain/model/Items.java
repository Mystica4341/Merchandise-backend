package com.mirera.merchandise.domain.model;

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

  public Integer getitemId() {
    return itemId;
  }

  public Categories getcategoryId() {
    return categoryId;
  }

  public String getitemName() {
    return itemName;
  }

  public String getdescription() {
    return description;
  }

}
