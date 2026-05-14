package com.mirera.merchandise.infrastructure.repository.categories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.mirera.merchandise.application.port.outbound.categories.CategoryRepository;
import com.mirera.merchandise.domain.categories.CategoriesEntity;

@Repository
public class CategoryRepositoryAdapter implements CategoryRepository {
  private final CategoryJpaRepository categoryJpaRepository;

  public CategoryRepositoryAdapter(CategoryJpaRepository categoryJpaRepository) {
    this.categoryJpaRepository = categoryJpaRepository;
  }

  @Override
  public Page<CategoriesEntity> findAllCategories(Pageable pageable) {
    return categoryJpaRepository.findAll(pageable);
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
