package com.davidrl.sap.mapper.mappers;

import com.davidrl.sap.dto.dtos.StoreDto;
import com.davidrl.sap.mapper.config.MapperConfigSap;
import com.davidrl.sap.entity.entities.Store;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfigSap.class,
    uses = {
        CategoryMapper.class
    })
public abstract class StoreMapper {

  public abstract StoreDto toDto(Store store);

  public abstract Store toEntity(StoreDto storeDto);
}
