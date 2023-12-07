package com.davidrl.sap.entity.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "CATEGORIES")
public class Category extends SapCommonEntity {

  @ManyToOne
  @JoinColumn(name = "STORE_ID", referencedColumnName = "ID", nullable = false)
  private Store store;

  @Column(name = "NAME", nullable = false)
  private String name;

  @Column(name = "DESCRIPTION")
  private String description;

  @Lob
  @Column(name = "IMAGE")
  private byte[] image;

  @OneToMany(mappedBy = "category")
  private List<Item> items = new ArrayList<>();
}
