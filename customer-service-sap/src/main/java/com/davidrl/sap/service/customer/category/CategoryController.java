package com.davidrl.sap.service.customer.category;


import com.davidrl.sap.dto.dtos.CategoryDto;
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
@RequestMapping(path = "/customer-service/category", produces = MediaType.APPLICATION_JSON_VALUE)
public class CategoryController {

  private final CategoryService categoryService;

  /**
   * Returns all the categories for indicated store
   *
   * @return Returns the response code 200 with all the categories.
   */
  @Operation(summary = "Returns the list of categories for indicated store")
  @ApiResponses(@ApiResponse(responseCode = "200", description = "The list of categories has been returned."))
  @GetMapping
  public List<CategoryDto> getCategories(@RequestParam @NotNull @Positive Long storeId) {
    return categoryService.getCategories(storeId);
  }
}
