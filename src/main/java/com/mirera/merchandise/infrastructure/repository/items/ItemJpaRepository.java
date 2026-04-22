package com.mirera.merchandise.infrastructure.repository.items;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mirera.merchandise.domain.items.ItemsEntity;

public interface ItemJpaRepository extends JpaRepository<ItemsEntity, Integer> {
  boolean existsByItemName(String itemName);
}
