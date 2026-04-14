package com.mirera.merchandise.application.port.inbound.categories;

import com.mirera.merchandise.domain.categories.CategoriesEntity;

public interface CategoryUseCase {
  void createCategory(String categoryName);

  void updateCategory(CategoriesEntity category);

  void softDeleteCategory(int id);

  void deleteCategoryById(int id);
}
