package com.mirera.merchandise.infrastructure.repository.categories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mirera.merchandise.domain.categories.CategoriesEntity;

public interface CategoryJpaRepository extends JpaRepository<CategoriesEntity, Integer> {
  boolean existsByCategoryName(String categoryName);
  
  CategoriesEntity findByCategoryName(String categoryName);
}
