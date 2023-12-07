package com.davidrl.sap.mapper.mappers;

import com.davidrl.sap.dto.dtos.ItemDto;
import com.davidrl.sap.mapper.config.MapperConfigSap;
import com.davidrl.sap.entity.entities.Item;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfigSap.class,
    uses = {
        CategoryMapper.class
    })
public abstract class ItemMapper {

  @Mapping(target = "categoryId", source = "category.id")
  public abstract ItemDto toDto(Item item);

  @Mapping(target = "category", ignore = true)
  public abstract Item toEntity(ItemDto itemDto);
}
