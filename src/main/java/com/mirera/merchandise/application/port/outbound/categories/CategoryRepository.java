package com.mirera.merchandise.application.port.outbound.categories;

import java.util.List;

import com.mirera.merchandise.domain.categories.CategoriesEntity;

public interface CategoryRepository{
  List<CategoriesEntity> findAll();

  CategoriesEntity findCategoryById(int id);

  void saveCategory(CategoriesEntity category);

  void deleteCategoryById(int id);
  
  boolean existsByName(String categoryName);
}
