package com.davidrl.sap.service.customer.item;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.davidrl.sap.dto.dtos.ItemDto;
import com.davidrl.sap.test.dto.ItemDtoParameterResolver;
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
@ExtendWith(ItemDtoParameterResolver.class)
class ItemControllerTest {

  @Autowired
  MockMvc mockMvc;


  @MockBean
  ItemService itemService;

  @Test
  void getItems_NoParameterReceived_Return404() throws Exception {
    // given

    // when / then
    mockMvc.perform(get("/customer-service/item"))
        .andDo(print())
        .andExpect(status().isBadRequest());
  }

  @Test
  void getItems_NoItemsFound_Return200() throws Exception {
    // given

    // when / then
    mockMvc.perform(get("/customer-service/item?categoryId=1"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(equalTo("[]")));
  }

  @Test
  void getItems_itemsFound_Return200(ItemDto itemDto) throws Exception {
    // given
    when(itemService.getItems(itemDto.getCategoryId())).thenReturn(Arrays.asList(itemDto));

    // when / then
    mockMvc.perform(get(String.format("/customer-service/item?categoryId=%d", itemDto.getCategoryId())))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(containsString(itemDto.getName())));
  }
}