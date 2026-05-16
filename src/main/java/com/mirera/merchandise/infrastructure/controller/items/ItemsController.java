package com.mirera.merchandise.infrastructure.controller.items;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mirera.merchandise.application.port.inbound.items.ItemUseCase;
import com.mirera.merchandise.application.port.inbound.items.request.ItemReqDTO;
import com.mirera.merchandise.application.port.inbound.items.response.ItemPageResDTO;
import com.mirera.merchandise.application.port.inbound.items.response.ItemResDTO;

@RestController
@RequestMapping("/api/items")
public class ItemsController {
  private final ItemUseCase itemUseCase;

  public ItemsController(ItemUseCase itemUseCase) {
    this.itemUseCase = itemUseCase;
  }

  @GetMapping
  public ItemPageResDTO getAllItems(Pageable pageable) {
    try {
      return itemUseCase.getAllItems(pageable);
    } catch (Exception e) {
      throw new RuntimeException("Error fetching items: " + e.getMessage());
    }
  }

  @GetMapping("/{id}")
  public ItemResDTO getItemById(@PathVariable int id) {
    try {
      return itemUseCase.getItemById(id);
    } catch (Exception e) {
      throw new RuntimeException("Error fetching item: " + e.getMessage());
    }
  }
    
  @PostMapping
  public String createItem(@RequestBody ItemReqDTO itemReqDTO) {
    try{
      itemUseCase.createItem(itemReqDTO);
      return "Tạo item thành công";
    } catch (IllegalArgumentException e) {
      return "Error: " + e.getMessage();
    }
  }

  @PutMapping("/{id}")
  public String updateItem(@RequestBody ItemReqDTO itemReqDTO, @PathVariable int id) {
    try {
      itemUseCase.updateItem(itemReqDTO, id);
      return "Cập nhật item thành công";
    } catch (IllegalArgumentException e) {
      return "Error: " + e.getMessage();
    }
  }

  @PutMapping("/soft-delete/{id}")
  public String softDeleteItem(@PathVariable int id) {
    try {
      itemUseCase.softDeleteItem(id);
      return "Xóa mềm item thành công";
    } catch (IllegalArgumentException e) {
      return "Error: " + e.getMessage();
    }
  }

  @DeleteMapping("/hard-delete/{id}")
  public String deleteItem(@PathVariable int id) {
    try {
      itemUseCase.deleteItemById(id);
      return "Xóa item thành công";
    } catch (IllegalArgumentException e) {
      return "Error: " + e.getMessage();
    }
  }
}
