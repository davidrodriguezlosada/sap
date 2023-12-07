package com.davidrl.sap.mapper.mappers;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.davidrl.sap.dto.dtos.CategoryDto;
import com.davidrl.sap.entity.entities.Category;
import com.davidrl.sap.test.dto.CategoryDtoParameterResolver;
import com.davidrl.sap.test.entity.CategoryParameterResolver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@ExtendWith(CategoryParameterResolver.class)
@ExtendWith(CategoryDtoParameterResolver.class)
class CategoryMapperTest {

  @InjectMocks
  CategoryMapperImpl categoryMapper;
  @Mock
  ItemMapperImpl itemMapper;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void testToDto(Category category) {
    // given

    // when
    CategoryDto categoryDto = categoryMapper.toDto(category);

    //then
    assertAll(
        () -> assertNotNull(categoryDto.getId()),
        () -> assertNotNull(categoryDto.getName()),
        () -> assertNotNull(categoryDto.getDescription()),
        () -> assertNotNull(categoryDto.getItems())
    );
  }

  @Test
  void testToEntity(CategoryDto categoryDto) {
    // given

    // when
    Category category = categoryMapper.toEntity(categoryDto);

    //then
    assertAll(
        () -> assertNotNull(category.getId()),
        () -> assertNotNull(category.getName()),
        () -> assertNotNull(category.getDescription()),
        () -> assertNotNull(category.getItems())
    );
  }
}