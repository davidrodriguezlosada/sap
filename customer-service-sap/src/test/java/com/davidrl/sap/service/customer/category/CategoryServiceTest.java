package com.davidrl.sap.service.customer.category;

import com.davidrl.sap.dto.dtos.CategoryDto;
import com.davidrl.sap.entity.entities.Category;
import com.davidrl.sap.entity.repositories.CategoryRepository;
import com.davidrl.sap.mapper.mappers.CategoryMapper;
import com.davidrl.sap.test.dto.CategoryDtoParameterResolver;
import com.davidrl.sap.test.entity.CategoryParameterResolver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith({CategoryDtoParameterResolver.class, CategoryParameterResolver.class})
class CategoryServiceTest {

  @InjectMocks
  CategoryService categoryService;
  @Mock
  CategoryRepository categoryRepository;
  @Mock
  CategoryMapper categoryMapper;

  @BeforeEach
  void setUp(CategoryDto categoryDto) {
    MockitoAnnotations.initMocks(this);

    when(categoryMapper.toDto(any())).thenReturn(categoryDto);
  }

  @Test
  void getCategories_categoryFound_returnCategoryDtoList(Category category) {
    // given
    when(categoryRepository.findByStoreId(1L)).thenReturn(Arrays.asList(category));

    // when
    List<CategoryDto> categoryDtos = categoryService.getCategories(1L);

    // then
    assertFalse(categoryDtos.isEmpty());
  }
}