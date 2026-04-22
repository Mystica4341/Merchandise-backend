package com.mirera.merchandise.application.service.items;

import com.mirera.merchandise.application.port.inbound.items.ItemUserCase;
import com.mirera.merchandise.application.port.outbound.items.ItemRepository;
import com.mirera.merchandise.domain.items.ItemsEntity;

public class ItemService implements ItemUserCase {
  private final ItemRepository itemRepo;

  public ItemService(ItemRepository itemRepo) {
    this.itemRepo = itemRepo;
  }

  @Override
  public void createItem(ItemsEntity item) {
    if (itemRepo.existsByItemName(item.getItemName())) {
      throw new IllegalArgumentException("Tên sản phẩm đã tồn tại.");
    }
    itemRepo.saveItem(item);
  }

  @Override
  public void updateItem(ItemsEntity item) {
    if (itemRepo.findItemById(item.getId()) == null) {
      throw new IllegalArgumentException("Sản phẩm không tồn tại.");
    }
    itemRepo.saveItem(item);
  }

  @Override
  public void softDeleteItem(int id) {
    ItemsEntity item = itemRepo.findItemById(id);
    if (item == null) {
      throw new IllegalArgumentException("Sản phẩm không tồn tại.");
    }
    if (item.getStatus() == true) {
      item.setStatus(false);
    } else item.setStatus(true);
    itemRepo.saveItem(item);
  }

  @Override   
  public void deleteItemById(int id) {
    ItemsEntity item = itemRepo.findItemById(id);
    if (item == null) {
      throw new IllegalArgumentException("Sản phẩm không tồn tại.");
    }
    itemRepo.deleteItemById(id);
  }
}
