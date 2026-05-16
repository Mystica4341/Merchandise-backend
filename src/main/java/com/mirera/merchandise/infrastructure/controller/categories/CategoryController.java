package com.mirera.merchandise.infrastructure.controller.categories;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mirera.merchandise.application.port.inbound.categories.CategoryUseCase;
import com.mirera.merchandise.application.port.inbound.categories.dto.response.CategoryPageResDTO;
import com.mirera.merchandise.application.port.inbound.categories.dto.response.CategoryResDTO;
import com.mirera.merchandise.domain.categories.CategoriesEntity;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;



@RestController
@RequestMapping("/api/categories")
public class CategoryController {
  private final CategoryUseCase categoryUseCase;

  public CategoryController(CategoryUseCase categoryUseCase) {
    this.categoryUseCase = categoryUseCase;
  }

  @GetMapping
  public CategoryPageResDTO getAllCategories(Pageable pageable) {
    try {
      return categoryUseCase.getAllCategories(pageable);
    } catch (Exception e) {
      throw new RuntimeException("Error fetching categories: " + e.getMessage());
    }
  }

  @GetMapping("/{id}")
  public CategoryResDTO getCategoryById(@PathVariable int id) {
    try {
      return categoryUseCase.getCategoryById(id);
    } catch (Exception e) {
      throw new RuntimeException("Error fetching category: " + e.getMessage());
    }
  }

  @PostMapping
  @SecurityRequirement(name = "BearerAuth")
  public String createCategory(@RequestParam String categoryName) {
    try {
      categoryUseCase.createCategory(categoryName);
      return "Tạo category thành công";
    } catch (IllegalArgumentException e) {
      return "Error: " + e.getMessage();
    }
  }

  @PutMapping("/{id}")
  @SecurityRequirement(name = "BearerAuth")
  public String updateCategory(@PathVariable int id, @RequestParam CategoriesEntity category) {
    try {
      categoryUseCase.updateCategory(id, category);
      return "Cập nhật category thành công";
    } catch (IllegalArgumentException e) {
      return "Error: " + e.getMessage();
    }
  }

  @PutMapping("/soft-delete/{id}")
  @SecurityRequirement(name = "BearerAuth")
  public String softDeleteCategory(@PathVariable int id) {
    try {
      categoryUseCase.softDeleteCategory(id);
      return "Xóa mềm category thành công";
    } catch (IllegalArgumentException e) {
      return "Error: " + e.getMessage();
    }
  }

  @DeleteMapping("/hard-delete/{id}")
  @SecurityRequirement(name = "BearerAuth")
  public String deleteCategory(@PathVariable int id) {
    try {
      categoryUseCase.deleteCategoryById(id);
      return "Xóa category thành công";
    } catch (IllegalArgumentException e) {
      return "Error: " + e.getMessage();
    }
  }
}
