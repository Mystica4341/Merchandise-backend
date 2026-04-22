package com.mirera.merchandise.infrastructure.repository.items;

import java.util.List;

import com.mirera.merchandise.application.port.outbound.items.ItemRepository;
import com.mirera.merchandise.domain.items.ItemsEntity;

public class ItemsRepositoryAdapter implements ItemRepository {
  private final ItemJpaRepository itemJpaRepository;

  public ItemsRepositoryAdapter(ItemJpaRepository itemJpaRepository) {
    this.itemJpaRepository = itemJpaRepository;
  }

  @Override
  public List<ItemsEntity> findAll() {
    return itemJpaRepository.findAll();
  }

  @Override
  public ItemsEntity findItemById(int id) {
    return itemJpaRepository.findById(id).orElse(null);
  }

  @Override
  public void saveItem(ItemsEntity item) {
    itemJpaRepository.save(item);
  }

  @Override
  public void deleteItemById(int id) {
    itemJpaRepository.deleteById(id);
  }

  @Override
  public boolean existsByItemName(String itemName) {
    return itemJpaRepository.existsByItemName(itemName);
  }
}
