package com.davidrl.sap.entity.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "ITEMS")
public class Item extends SapCommonEntity {

  @ManyToOne
  @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "ID", nullable = false)
  private Category category;

  @Column(name = "NAME", nullable = false)
  private String name;

  @Column(name = "DESCRIPTION")
  private String description;

  @Column(name = "IMAGE")
  private byte[] image;

  @Column(name = "PRICE")
  private Long price;

  @Column(name = "CURRENCY")
  private String currency;
}
