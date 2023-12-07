package com.davidrl.sap.service.customer.item;

import com.davidrl.sap.dto.dtos.ItemDto;
import com.davidrl.sap.entity.repositories.ItemRepository;
import com.davidrl.sap.mapper.mappers.ItemMapper;
import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ItemService {

  private final ItemRepository itemRepository;
  private final ItemMapper itemMapper;

  protected List<ItemDto> getItems(Long categoryId) {
    return IterableUtils.toList(itemRepository.findByCategoryId(categoryId)).stream().map(itemMapper::toDto).collect(
        Collectors.toList());
  }
}
