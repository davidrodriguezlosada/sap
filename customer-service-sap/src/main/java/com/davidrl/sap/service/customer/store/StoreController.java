package com.davidrl.sap.service.customer.store;

import com.davidrl.sap.dto.dtos.StoreDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/** Represents the controller that provides REST endpoints for the stores. */
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/customer-service/store", produces = MediaType.APPLICATION_JSON_VALUE)
public class StoreController {

  private final StoreService storeService;

  /**
   * Returns all the stores in the system
   *
   * @return Returns the response code 200 with all the stores.
   */
  @Operation(summary = "Returns the list of stores")
  @ApiResponses(@ApiResponse(responseCode = "200", description = "The list of stores has been returned."))
  @GetMapping
  public List<StoreDto> getStores() {
    return storeService.getStores();
  }
}
