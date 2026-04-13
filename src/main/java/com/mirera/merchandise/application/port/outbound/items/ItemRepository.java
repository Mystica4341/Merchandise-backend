package com.mirera.merchandise.application.port.outbound.items;

import com.mirera.merchandise.domain.items.Items;
import com.mirera.merchandise.domain.items.ItemsDetail;

public interface ItemRepository {
  void findAll();

  Items findItemById(int itemId);

  void saveItem(Items item);

  void saveItemDetails(ItemsDetail itemDetail);

  void deleteItem(Items item);

  void deleteItemById(int itemId);

  boolean existsByName(String name);
}
