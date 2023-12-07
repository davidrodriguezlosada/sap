package com.davidrl.sap.service.customer.item;


import com.davidrl.sap.dto.dtos.ItemDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

/** Represents the controller that provides REST endpoints for the categories. */
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/customer-service/item", produces = MediaType.APPLICATION_JSON_VALUE)
public class ItemController {

  private final ItemService itemService;

  /**
   * Returns all the items for indicated category
   *
   * @return Returns the response code 200 with all the categories.
   */
  @Operation(summary = "Returns the list of items by indicated category")
  @ApiResponses(@ApiResponse(responseCode = "200", description = "The list of items has been returned."))
  @GetMapping
  public List<ItemDto> getItems(@RequestParam @NotNull @Positive Long categoryId) {
    return itemService.getItems(categoryId);
  }
}
