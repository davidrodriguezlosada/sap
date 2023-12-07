package com.davidrl.sap.dto.dtos;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
public class ItemDto extends SapCommonDto implements Serializable {

  private Long categoryId;
  private String name;
  private String description;
  private byte[] image;
  private Long price;
  private String currency;
}
