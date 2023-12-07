package com.davidrl.sap.service.customer.store;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.davidrl.sap.dto.dtos.StoreDto;
import com.davidrl.sap.test.dto.StoreDtoParameterResolver;
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
@ExtendWith(StoreDtoParameterResolver.class)
class StoreControllerTest {

  @Autowired
  MockMvc mockMvc;

  @MockBean
  StoreService storeService;

  @Test
  void getStores_noStoresFound_returns200() throws Exception {
    // given

    // when / then
    mockMvc.perform(get("/customer-service/store"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(equalTo("[]")));
  }

  @Test
  void getStores_storesFound_returns200(StoreDto storeDto) throws Exception {
    // given
    when(storeService.getStores()).thenReturn(Arrays.asList(storeDto));

    // when / then
    mockMvc.perform(get("/customer-service/store"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(containsString(storeDto.getName())));
  }
}