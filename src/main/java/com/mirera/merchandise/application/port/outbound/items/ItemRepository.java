package com.mirera.merchandise.application.port.outbound.items;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mirera.merchandise.domain.items.ItemsEntity;

public interface ItemRepository {
  Page<ItemsEntity> findAllItems(Pageable pageable);

  ItemsEntity findItemById(int id);

  void saveItem(ItemsEntity item);

  void deleteItemById(int id);

  boolean existsByItemName(String itemName);
}
