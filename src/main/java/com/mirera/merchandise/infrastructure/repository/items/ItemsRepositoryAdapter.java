package com.mirera.merchandise.infrastructure.repository.items;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.mirera.merchandise.application.port.outbound.items.ItemRepository;
import com.mirera.merchandise.domain.items.ItemsEntity;

@Repository
public class ItemsRepositoryAdapter implements ItemRepository {
  private final ItemJpaRepository itemJpaRepository;

  public ItemsRepositoryAdapter(ItemJpaRepository itemJpaRepository) {
    this.itemJpaRepository = itemJpaRepository;
  }

  @Override
  public Page<ItemsEntity> findAllItems(Pageable pageable) {
    return itemJpaRepository.findAll(pageable);
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
