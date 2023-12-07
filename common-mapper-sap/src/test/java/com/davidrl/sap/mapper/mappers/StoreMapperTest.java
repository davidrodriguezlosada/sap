package com.davidrl.sap.mapper.mappers;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.davidrl.sap.dto.dtos.StoreDto;
import com.davidrl.sap.entity.entities.Store;
import com.davidrl.sap.test.dto.StoreDtoParameterResolver;
import com.davidrl.sap.test.entity.StoreParameterResolver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@ExtendWith(StoreParameterResolver.class)
@ExtendWith(StoreDtoParameterResolver.class)
class StoreMapperTest {

  @InjectMocks
  StoreMapperImpl storeMapper;
  @Mock
  CategoryMapperImpl categoryMapper;
  @Mock
  ItemMapperImpl itemMapper;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void testToDto(Store store) {
    // given

    // when
    StoreDto storeDto = storeMapper.toDto(store);

    //then
    assertAll(
        () -> assertNotNull(storeDto.getId()),
        () -> assertNotNull(storeDto.getName()),
        () -> assertNotNull(storeDto.getDescription()),
        () -> assertNotNull(storeDto.getCategories())
    );
  }

  @Test
  void testToEntity(StoreDto storeDto) {
    // given

    // when
    Store store = storeMapper.toEntity(storeDto);

    //then
    assertAll(
        () -> assertNotNull(store.getId()),
        () -> assertNotNull(store.getName()),
        () -> assertNotNull(store.getDescription()),
        () -> assertNotNull(store.getCategories())
    );
  }
}