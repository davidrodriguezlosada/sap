package com.davidrl.sap.test.entity;

import com.davidrl.sap.entity.entities.Category;
import com.davidrl.sap.entity.entities.Item;
import java.util.List;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class CategoryParameterResolver implements ParameterResolver {

  public static final long ID = 1L;
  public static final String NAME = "category.name";
  public static final String DESCRIPTION = "category.description";

  @Override
  public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
      throws ParameterResolutionException {
    return parameterContext.getParameter().getType() == Category.class;
  }

  @Override
  public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
      throws ParameterResolutionException {

    return this.createCategory();
  }

  protected Category createCategory() {
    return Category.builder().name(NAME).description(DESCRIPTION).items(getItems()).id(ID).build();
  }

  protected List<Category> createCategoryList() {
    return List.of(createCategory());
  }

  private List<Item> getItems() {
    return new ItemParameterResolver().createItemList();
  }
}
