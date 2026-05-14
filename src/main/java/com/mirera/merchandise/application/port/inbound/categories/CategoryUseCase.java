package com.mirera.merchandise.application.port.inbound.categories;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Pageable;

import com.mirera.merchandise.application.port.inbound.categories.dto.response.CategoryPageResDTO;
import com.mirera.merchandise.application.port.inbound.categories.dto.response.CategoryResDTO;
import com.mirera.merchandise.domain.categories.CategoriesEntity;

@Configuration
public interface CategoryUseCase {
  CategoryPageResDTO getAllCategories(Pageable pageable);

  CategoryResDTO getCategoryById(int id);

  void createCategory(String categoryName);

  void updateCategory(int id, CategoriesEntity category);

  void softDeleteCategory(int id);

  void deleteCategoryById(int id);
}
