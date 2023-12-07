package com.davidrl.sap.test.dto;

import com.davidrl.sap.dto.dtos.CategoryDto;
import com.davidrl.sap.dto.dtos.StoreDto;
import java.util.List;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class StoreDtoParameterResolver implements ParameterResolver {

  public static final long ID = 1L;
  public static final String NAME = "store.name";
  public static final String DESCRIPTION = "store.description";

  @Override
  public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
      throws ParameterResolutionException {
    return parameterContext.getParameter().getType() == StoreDto.class;
  }

  @Override
  public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
      throws ParameterResolutionException {

    return createStore();
  }

  protected StoreDto createStore() {
      return StoreDto.builder().name(NAME).description(DESCRIPTION).categories(getCategories()).id(ID).build();
  }

  private List<CategoryDto> getCategories() {
    return new CategoryDtoParameterResolver().createCategoryList();
  }
}
