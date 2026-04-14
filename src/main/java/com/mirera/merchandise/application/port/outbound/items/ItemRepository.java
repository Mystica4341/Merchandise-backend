package com.mirera.merchandise.application.port.outbound.items;

import java.util.List;

import com.mirera.merchandise.domain.items.ItemsEntity;

public interface ItemRepository {
  List<ItemsEntity> findAll();

  ItemsEntity findItemById(int itemId);

  void saveItem(ItemsEntity item);

  void deleteItemById(int id);

  boolean existsByName(String itemName);
}
