package com.mirera.merchandise.application.port.inbound.items;

import com.mirera.merchandise.domain.items.ItemsEntity;

public interface ItemUserCase {
  void createItem(ItemsEntity item);

  void updateItem(ItemsEntity item);

  void softDeleteItem(int id);

  void deleteItemById(int id);
}
