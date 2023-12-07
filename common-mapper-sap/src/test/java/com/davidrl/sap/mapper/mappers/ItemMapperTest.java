package com.davidrl.sap.mapper.mappers;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.davidrl.sap.dto.dtos.ItemDto;
import com.davidrl.sap.entity.entities.Item;
import com.davidrl.sap.test.dto.ItemDtoParameterResolver;
import com.davidrl.sap.test.entity.ItemParameterResolver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

@ExtendWith(ItemParameterResolver.class)
@ExtendWith(ItemDtoParameterResolver.class)
class ItemMapperTest {

  @InjectMocks
  ItemMapperImpl itemMapper;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void testToDto(Item item) {
    // given

    // when
    ItemDto itemDto = itemMapper.toDto(item);

    //then
    assertAll(
        () -> assertNotNull(itemDto.getId()),
        () -> assertNotNull(itemDto.getName()),
        () -> assertNotNull(itemDto.getDescription()),
        () -> assertNotNull(itemDto.getPrice()),
        () -> assertNotNull(itemDto.getCurrency())
    );
  }

  @Test
  void testToEntity(ItemDto itemDto) {
    // given

    // when
    Item item = itemMapper.toEntity(itemDto);

    //then
    assertAll(
        () -> assertNotNull(item.getId()),
        () -> assertNotNull(item.getName()),
        () -> assertNotNull(item.getDescription()),
        () -> assertNotNull(item.getPrice()),
        () -> assertNotNull(item.getCurrency())
    );
  }
}