package com.davidrl.sap.mapper.mappers;

import com.davidrl.sap.dto.dtos.CategoryDto;
import com.davidrl.sap.entity.entities.Category;
import com.davidrl.sap.mapper.config.MapperConfigSap;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfigSap.class,
    uses = {
        ItemMapper.class,
        StoreMapper.class
    })
public abstract class CategoryMapper {

  @Mapping(target = "storeId", source = "store.id")
  public abstract CategoryDto toDto(Category category);

  @Mapping(target = "store", ignore = true)
  public abstract Category toEntity(CategoryDto categoryDto);
}
