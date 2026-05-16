package com.mirera.merchandise.application.service.items;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mirera.merchandise.application.port.inbound.items.ItemUseCase;
import com.mirera.merchandise.application.port.inbound.items.request.ItemReqDTO;
import com.mirera.merchandise.application.port.inbound.items.response.ItemPageResDTO;
import com.mirera.merchandise.application.port.inbound.items.response.ItemResDTO;
import com.mirera.merchandise.application.port.outbound.categories.CategoryRepository;
import com.mirera.merchandise.application.port.outbound.items.ItemRepository;
import com.mirera.merchandise.domain.categories.CategoriesEntity;
import com.mirera.merchandise.domain.items.ItemsEntity;

@Service
public class ItemService implements ItemUseCase {
  private final ItemRepository itemRepo;
  private final CategoryRepository categoryRepo;

  public ItemService(ItemRepository itemRepo, CategoryRepository categoryRepo) {
    this.itemRepo = itemRepo;
    this.categoryRepo = categoryRepo;
  }

  @Override
  public ItemPageResDTO getAllItems(Pageable pageable) {
    Page<ItemsEntity> response = itemRepo.findAllItems(pageable);

    if (response == null || response.getContent().isEmpty()) {
      throw new IllegalArgumentException("Không có sản phẩm nào.");
    }
    
    List<ItemResDTO> items = response.getContent().stream()
      .map(this::toResponse)
      .toList();

    return new ItemPageResDTO(
      response.getNumber(),
      response.getSize(),
      response.getTotalPages(),
      response.getTotalElements(),
      items
    );
  }

  @Override
  public ItemResDTO getItemById(int id) {
    ItemsEntity item = itemRepo.findItemById(id);

    if (item == null) {
      throw new IllegalArgumentException("Sản phẩm không tồn tại.");
    }

    return toResponse(item);
  }

  @Override
  public void createItem(ItemReqDTO request) {
    if (itemRepo.existsByItemName(request.itemName())) {
      throw new IllegalArgumentException("Tên sản phẩm đã tồn tại.");
    }

    ItemsEntity item = new ItemsEntity();
    item.setItemName(request.itemName());
    item.setItemDescription(request.itemDescription());
    item.setItemPrice(request.itemPrice());
    item.setItemImageUrl(request.itemImageUrl());
    item.setStockQuantity(request.stockQuantity());
    item.setItemColor(request.itemColor());
    item.setItemSize(request.itemSize());
    item.setStatus(parseStatus(request.status()));
    item.setCategories(mappingCategories(request.categoryIds()));

    itemRepo.saveItem(item);
  }

  @Override
  public void updateItem(ItemReqDTO request, int id) {
    ItemsEntity item = existsItemById(id);
    if (item == null) {
      throw new IllegalArgumentException("Sản phẩm không tồn tại.");
    }

    item.setItemName(request.itemName());
    item.setItemDescription(request.itemDescription());
    item.setItemPrice(request.itemPrice());
    item.setItemImageUrl(request.itemImageUrl());
    item.setStockQuantity(request.stockQuantity());
    item.setItemColor(request.itemColor());
    item.setItemSize(request.itemSize());
    item.setStatus(parseStatus(request.status()));
    item.setCategories(mappingCategories(request.categoryIds()));

    itemRepo.saveItem(item);
  }

  @Override
  public void softDeleteItem(int id) {
    ItemsEntity item = existsItemById(id);

    if (item.getStatus() == true) {
      item.setStatus(false);
    } else item.setStatus(true);
    itemRepo.saveItem(item);
  }

  @Override   
  public void deleteItemById(int id) {
    existsItemById(id);

    itemRepo.deleteItemById(id);
  }

  public ItemsEntity existsItemById(int id) {
    ItemsEntity item = itemRepo.findItemById(id);
    if (item == null) {
      throw new IllegalArgumentException("Sản phẩm không tồn tại.");
    }
    return item;
  }

  private Set<CategoriesEntity> mappingCategories(List<Integer> categoryIds) {
    if (categoryIds == null || categoryIds.isEmpty()) {
      return Set.of();
    }
    
    return categoryIds.stream()
      .map(id -> {
        CategoriesEntity category = categoryRepo.findCategoryById(id);
        if (category == null) {
          throw new IllegalArgumentException("Danh mục không tồn tại: " + id);
        }
        return category;
      })
      .collect(Collectors.toSet());
  }

  private ItemResDTO toResponse(ItemsEntity item) {
    List<ItemResDTO.CategoriesRes> categories =
      item.getCategories() == null ? List.of() :
      item.getCategories().stream()
        .map(c -> new ItemResDTO.CategoriesRes(c.getId(), c.getCategoryName()))
        .toList();

    return new ItemResDTO(
      item.getId(),
      item.getItemName(),
      item.getItemDescription(),
      item.getItemPrice(),
      item.getItemImageUrl(),
      item.getStockQuantity(),
      item.getItemColor(),
      item.getItemSize(),
      item.getStatus(),
      categories,
      item.getCreatedAt(),
      item.getUpdatedAt()
    );
  }

  private boolean parseStatus(String status) {
    return status == null || Boolean.parseBoolean(status);
  }
}
