package com.davidrl.sap.service.customer.category;

import com.davidrl.sap.dto.dtos.CategoryDto;
import com.davidrl.sap.entity.repositories.CategoryRepository;
import com.davidrl.sap.mapper.mappers.CategoryMapper;
import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoryService {

  private final CategoryRepository categoryRepository;
  private final CategoryMapper categoryMapper;

  protected List<CategoryDto> getCategories(Long storeId) {
    return IterableUtils.toList(categoryRepository.findByStoreId(storeId)).stream().map(categoryMapper::toDto).collect(
        Collectors.toList());
  }
}
