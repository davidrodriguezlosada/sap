package com.davidrl.sap.dto.dtos;

import java.io.Serializable;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
public class StoreDto extends SapCommonDto implements Serializable {

  private String name;
  private String description;
  private byte[] logo;
  private List<CategoryDto> categories;
}
