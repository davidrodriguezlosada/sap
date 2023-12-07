package com.davidrl.sap.test.entity;

import com.davidrl.sap.entity.entities.Item;
import java.util.List;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class ItemParameterResolver implements ParameterResolver {

  public static final long ID = 1L;
  public static final String NAME = "item.name";
  public static final String DESCRIPTION = "item.description";
  public static final Long PRICE = 10L;
  public static final String CURRENCY = "€";

  @Override
  public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
      throws ParameterResolutionException {
    return parameterContext.getParameter().getType() == Item.class;
  }

  @Override
  public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
      throws ParameterResolutionException {

    return this.createItem();
  }

  protected Item createItem() {
    return Item.builder().name(NAME).description(DESCRIPTION).id(ID).price(PRICE).currency(CURRENCY).build();
  }

  protected List<Item> createItemList() {
    return List.of(createItem());
  }
}
