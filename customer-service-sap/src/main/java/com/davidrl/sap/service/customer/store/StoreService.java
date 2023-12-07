package com.davidrl.sap.service.customer.store;

import com.davidrl.sap.dto.dtos.StoreDto;
import com.davidrl.sap.entity.repositories.StoreRepository;
import com.davidrl.sap.mapper.mappers.StoreMapper;
import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StoreService {

  private final StoreRepository storeRepository;
  private final StoreMapper storeMapper;

  protected List<StoreDto> getStores() {
    return IterableUtils.toList(storeRepository.findAll()).stream().map(storeMapper::toDto).collect(
        Collectors.toList());
  }
}
