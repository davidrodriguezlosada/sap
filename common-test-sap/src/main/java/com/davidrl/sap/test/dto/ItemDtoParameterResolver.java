package com.davidrl.sap.test.dto;

import com.davidrl.sap.dto.dtos.ItemDto;
import java.util.List;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class ItemDtoParameterResolver implements ParameterResolver {

  public static final long ID = 1L;
  public static final String NAME = "item.name";
  public static final String DESCRIPTION = "item.description";
  public static final Long PRICE = 10L;
  public static final String CURRENCY = "€";
  public static final Long CATEGORY_ID = 1L;

  @Override
  public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
      throws ParameterResolutionException {
    return parameterContext.getParameter().getType() == ItemDto.class;
  }

  @Override
  public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
      throws ParameterResolutionException {

    return this.createItem();
  }

  protected ItemDto createItem() {
    return ItemDto.builder().name(NAME).description(DESCRIPTION).categoryId(CATEGORY_ID).id(ID).price(PRICE).currency(CURRENCY).build();
  }

  protected List<ItemDto> createItemList() {
    return List.of(createItem());
  }
}
