package com.mirera.merchandise.application.service.categories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mirera.merchandise.application.port.inbound.categories.CategoryUseCase;
import com.mirera.merchandise.application.port.inbound.categories.dto.response.CategoryPageResDTO;
import com.mirera.merchandise.application.port.inbound.categories.dto.response.CategoryResDTO;
import com.mirera.merchandise.application.port.outbound.categories.CategoryRepository;
import com.mirera.merchandise.domain.categories.CategoriesEntity;

@Service
public class CategoryService implements CategoryUseCase {
  private final CategoryRepository categoryRepo;

  public CategoryService(CategoryRepository categoryRepo) {
    this.categoryRepo = categoryRepo;
  }
  
  @Override
  public CategoryPageResDTO getAllCategories(Pageable pageable) {
    Page<CategoriesEntity> response = categoryRepo.findAllCategories(pageable);

    List<CategoryResDTO>  category = response.getContent().stream()
      .map(c -> new CategoryResDTO(
        c.getId(),
        c.getCategoryName(),
        c.getDescription()
      ))
      .toList();

    return new CategoryPageResDTO(
      response.getNumber(),
      response.getSize(),
      response.getTotalPages(),
      response.getTotalElements(),
      category
    );
  }

  @Override
  public CategoryResDTO getCategoryById(int id) {
    CategoriesEntity category = existsCategoryById(id);

    return new CategoryResDTO(
      category.getId(),
      category.getCategoryName(),
      category.getDescription()
    );
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
  public void updateCategory(int id, CategoriesEntity category) {
    CategoriesEntity existingCategory = existsCategoryById(id);

    existingCategory.setCategoryName(category.getCategoryName());
    existingCategory.setDescription(category.getDescription());

    categoryRepo.saveCategory(existingCategory);
  }

  @Override
  public void softDeleteCategory(int id) {
    CategoriesEntity category = existsCategoryById(id);

    if (category.getStatus() == true) {
      category.setStatus(false);
    } else category.setStatus(true);

    categoryRepo.saveCategory(category);
  }

  @Override
  public void deleteCategoryById(int id) {
    existsCategoryById(id);

    categoryRepo.deleteCategoryById(id);
  }

  public CategoriesEntity existsCategoryById(int id) {
    CategoriesEntity category = categoryRepo.findCategoryById(id);
    if (category == null) {
      throw new IllegalArgumentException("Danh mục không tồn tại.");
    }
    return category;
  }
}
