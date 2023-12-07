package com.davidrl.sap.service.customer.store;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.davidrl.sap.dto.dtos.StoreDto;
import com.davidrl.sap.entity.entities.Store;
import com.davidrl.sap.entity.repositories.StoreRepository;
import com.davidrl.sap.mapper.mappers.StoreMapperImpl;
import com.davidrl.sap.test.dto.StoreDtoParameterResolver;
import com.davidrl.sap.test.entity.StoreParameterResolver;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


@ExtendWith({StoreParameterResolver.class, StoreDtoParameterResolver.class})
class StoreServiceTest {

  @InjectMocks
  StoreService storeService;
  @Mock
  StoreRepository storeRepository;
  @Mock
  StoreMapperImpl storeMapper;

  @BeforeEach
  void setUp(StoreDto storeDto) {
    MockitoAnnotations.initMocks(this);

    when(storeMapper.toDto(any())).thenReturn(storeDto);
  }

  @Test
  void getStores_storeFound_returnsStoreDtoList(Store store) {
    // given
    when(storeRepository.findAll()).thenReturn(Arrays.asList(store));

    // when
    List<StoreDto> storeDtos = storeService.getStores();

    // then
    assertFalse(storeDtos.isEmpty());
  }
}