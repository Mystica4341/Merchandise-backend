package com.mirera.merchandise.application.port.outbound.categories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mirera.merchandise.domain.categories.CategoriesEntity;

public interface CategoryRepository{
  Page<CategoriesEntity> findAllCategories(Pageable pageable);

  CategoriesEntity findCategoryById(int id);

  void saveCategory(CategoriesEntity category);

  void deleteCategoryById(int id);
  
  boolean existsByCategoryName(String categoryName);
}
