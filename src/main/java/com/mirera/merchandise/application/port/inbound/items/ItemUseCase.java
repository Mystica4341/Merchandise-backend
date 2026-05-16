package com.mirera.merchandise.application.port.inbound.items;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Pageable;

import com.mirera.merchandise.application.port.inbound.items.request.ItemReqDTO;
import com.mirera.merchandise.application.port.inbound.items.response.ItemPageResDTO;
import com.mirera.merchandise.application.port.inbound.items.response.ItemResDTO;

@Configuration
public interface ItemUseCase {
  ItemPageResDTO getAllItems(Pageable pageable);

  ItemResDTO getItemById(int id);

  void createItem(ItemReqDTO itemReqDTO);

  void updateItem(ItemReqDTO itemReqDTO, int id);

  void softDeleteItem(int id);

  void deleteItemById(int id);
}
