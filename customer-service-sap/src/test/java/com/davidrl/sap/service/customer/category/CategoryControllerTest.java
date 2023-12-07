package com.davidrl.sap.service.customer.category;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.davidrl.sap.dto.dtos.CategoryDto;
import com.davidrl.sap.test.dto.CategoryDtoParameterResolver;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(CategoryDtoParameterResolver.class)
class CategoryControllerTest {

  @Autowired
  MockMvc mockMvc;

  @MockBean
  CategoryService categoryService;

  @Test
  void getCategories_NoParameterReceived_Return404() throws Exception {
    // given

    // when / then
    mockMvc.perform(get("/customer-service/category"))
        .andDo(print())
        .andExpect(status().isBadRequest());
  }

  @Test
  void getCategories_NoCategoriesFound_Return200() throws Exception {
    // given

    // when / then
    mockMvc.perform(get("/customer-service/category?storeId=1"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(equalTo("[]")));
  }

  @Test
  void getCategories_categoriesFound_Return200(CategoryDto categoryDto) throws Exception {
    // given
    when(categoryService.getCategories(categoryDto.getStoreId())).thenReturn(Arrays.asList(categoryDto));

    // when / then
    mockMvc.perform(get(String.format("/customer-service/category?storeId=%d", categoryDto.getStoreId())))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(containsString(categoryDto.getName())));
  }
}