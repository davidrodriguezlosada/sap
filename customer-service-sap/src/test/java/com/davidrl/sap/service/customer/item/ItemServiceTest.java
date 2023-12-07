package com.davidrl.sap.service.customer.item;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.davidrl.sap.dto.dtos.ItemDto;
import com.davidrl.sap.entity.entities.Item;
import com.davidrl.sap.entity.repositories.ItemRepository;
import com.davidrl.sap.mapper.mappers.ItemMapperImpl;
import com.davidrl.sap.test.dto.ItemDtoParameterResolver;
import com.davidrl.sap.test.entity.ItemParameterResolver;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@ExtendWith({ItemParameterResolver.class, ItemDtoParameterResolver.class})
class ItemServiceTest {

  @InjectMocks
  ItemService itemService;
  @Mock
  ItemRepository itemRepository;
  @Mock
  ItemMapperImpl itemMapper;

  @BeforeEach
  void setUp(ItemDto itemDto) {
    MockitoAnnotations.initMocks(this);

    when(itemMapper.toDto(any())).thenReturn(itemDto);
  }

  @Test
  void getItems_itemFound_returnsItemDtoList(Item item) {
    // given
    when(itemRepository.findByCategoryId(1L)).thenReturn(Arrays.asList(item));

    // when
    List<ItemDto> itemDtos = itemService.getItems(1L);

    // then
    assertFalse(itemDtos.isEmpty());
  }
}