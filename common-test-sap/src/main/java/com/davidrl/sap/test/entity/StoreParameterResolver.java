package com.davidrl.sap.test.entity;

import com.davidrl.sap.entity.entities.Category;
import com.davidrl.sap.entity.entities.Store;
import java.util.List;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class StoreParameterResolver implements ParameterResolver {

  public static final long ID = 1L;
  public static final String NAME = "store.name";
  public static final String DESCRIPTION = "store.description";

  @Override
  public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
      throws ParameterResolutionException {
    return parameterContext.getParameter().getType() == Store.class;
  }

  @Override
  public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
      throws ParameterResolutionException {

    return createStore();
  }

  protected Store createStore() {
      return Store.builder().name(NAME).description(DESCRIPTION).categories(getCategories()).id(ID).build();
  }

  private List<Category> getCategories() {
    return new CategoryParameterResolver().createCategoryList();
  }
}
