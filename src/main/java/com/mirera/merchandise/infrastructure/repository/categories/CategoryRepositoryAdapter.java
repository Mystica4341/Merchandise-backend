package com.mirera.merchandise.infrastructure.repository.categories;

import java.util.List;

import com.mirera.merchandise.application.port.outbound.categories.CategoryRepository;
import com.mirera.merchandise.domain.categories.CategoriesEntity;

public class CategoryRepositoryAdapter implements CategoryRepository {
  private final CategoryJpaRepository categoryJpaRepository;

  public CategoryRepositoryAdapter(CategoryJpaRepository categoryJpaRepository) {
    this.categoryJpaRepository = categoryJpaRepository;
  }

  @Override
  public List<CategoriesEntity> findAll() {
    return categoryJpaRepository.findAll();
  }

  @Override
  public CategoriesEntity findCategoryById(int id) {
    return categoryJpaRepository.findById(id).orElse(null);
  }

  @Override
  public void saveCategory(CategoriesEntity category) {
    categoryJpaRepository.save(category);
  }

  @Override
  public void deleteCategoryById(int id) {
    categoryJpaRepository.deleteById(id);
  }

  @Override
  public boolean existsByCategoryName(String categoryName) {
    return categoryJpaRepository.existsByCategoryName(categoryName);
  }
  
}
