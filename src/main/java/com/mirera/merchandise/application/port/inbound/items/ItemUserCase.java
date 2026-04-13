package com.mirera.merchandise.application.port.inbound.items;

import com.mirera.merchandise.domain.items.Items;
import com.mirera.merchandise.domain.items.ItemsDetail;

public interface ItemUserCase {
  void createItem(Items item, ItemsDetail itemDetail);

  void updateItem(Items item, ItemsDetail itemDetail);

  void deleteItem(Items item);

  void deleteItemById(int itemId);
}
