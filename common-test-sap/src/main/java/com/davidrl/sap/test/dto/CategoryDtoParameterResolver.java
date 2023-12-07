package com.davidrl.sap.test.dto;

import com.davidrl.sap.dto.dtos.CategoryDto;
import com.davidrl.sap.dto.dtos.ItemDto;
import java.util.List;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class CategoryDtoParameterResolver implements ParameterResolver {

  public static final long ID = 1L;
  public static final String NAME = "category.name";
  public static final String DESCRIPTION = "category.description";
  public static final Long STORE_ID = 1L;

  @Override
  public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
      throws ParameterResolutionException {
    return parameterContext.getParameter().getType() == CategoryDto.class;
  }

  @Override
  public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
      throws ParameterResolutionException {

    return createCategory();
  }

  protected CategoryDto createCategory() {
    return CategoryDto.builder().name(NAME).description(DESCRIPTION).items(getItems()).storeId(STORE_ID).id(ID).build();
  }

  protected List<CategoryDto> createCategoryList() {
    return List.of(createCategory());
  }

  private List<ItemDto> getItems() {
    return new ItemDtoParameterResolver().createItemList();
  }
}
