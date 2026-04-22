package com.mirera.merchandise.application.service.categories;

import com.mirera.merchandise.application.port.inbound.categories.CategoryUseCase;
import com.mirera.merchandise.application.port.outbound.categories.CategoryRepository;
import com.mirera.merchandise.domain.categories.CategoriesEntity;

public class CategoryService implements CategoryUseCase {
  private final CategoryRepository categoryRepo;

  public CategoryService(CategoryRepository categoryRepo) {
    this.categoryRepo = categoryRepo;
  }

  @Override
  public void createCategory(String categoryName) {
    CategoriesEntity category = new CategoriesEntity();
    category.setCategoryName(categoryName);
    if (categoryRepo.existsByCategoryName(categoryName)) {
      throw new IllegalArgumentException("Danh mục đã tồn tại.");
    }
    categoryRepo.saveCategory(category);
  }

  @Override
  public void updateCategory(CategoriesEntity category) {
    if (categoryRepo.findCategoryById(category.getId()) == null) {
      throw new IllegalArgumentException("Danh mục không tồn tại.");
    }
    categoryRepo.saveCategory(category);
  }

  @Override
  public void softDeleteCategory(int id) {
    CategoriesEntity category = categoryRepo.findCategoryById(id);
    if (category == null) {
      throw new IllegalArgumentException("Danh mục không tồn tại.");
    }
    if (category.getStatus() == true) {
      category.setStatus(false);
    } else category.setStatus(true);
    categoryRepo.saveCategory(category);
  }

  @Override
  public void deleteCategoryById(int id) {
    CategoriesEntity category = categoryRepo.findCategoryById(id);
    if (category == null) {
      throw new IllegalArgumentException("Danh mục không tồn tại.");
    }
    categoryRepo.deleteCategoryById(id);
  }
}
