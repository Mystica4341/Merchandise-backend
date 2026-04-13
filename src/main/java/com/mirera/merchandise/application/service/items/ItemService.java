package com.mirera.merchandise.application.service.items;

import com.mirera.merchandise.application.port.inbound.items.ItemUserCase;
import com.mirera.merchandise.application.port.outbound.items.ItemRepository;
import com.mirera.merchandise.domain.items.Items;
import com.mirera.merchandise.domain.items.ItemsDetail;

public class ItemService implements ItemUserCase {
  private final ItemRepository itemRepo;

  public ItemService(ItemRepository itemRepo) {
    this.itemRepo = itemRepo;
  }

  @Override
  public void createItem(Items item, ItemsDetail itemDetail) {
    if (itemRepo.existsByName(item.getItemName())) {
      throw new IllegalArgumentException("Tên sản phẩm đã tồn tại.");
    }
    itemRepo.saveItem(item);
    itemRepo.saveItemDetails(itemDetail);
  }

  @Override
  public void updateItem(Items item, ItemsDetail itemDetail) {
    if (!itemRepo.existsByName(item.getItemName())) {
      throw new IllegalArgumentException("Sản phẩm không tồn tại.");
    }
    itemRepo.saveItem(item);
    itemRepo.saveItemDetails(itemDetail);
  }

  @Override
  public void deleteItem(Items item) {
    if (!itemRepo.existsByName(item.getItemName())) {
      throw new IllegalArgumentException("Sản phẩm không tồn tại.");
    }
    itemRepo.deleteItem(item);
  }

  @Override
  public void deleteItemById(int itemId) {
    Items item = itemRepo.findItemById(itemId);
    if (item == null) {
      throw new IllegalArgumentException("Sản phẩm không tồn tại.");
    }
    itemRepo.deleteItemById(itemId);
  }
}
