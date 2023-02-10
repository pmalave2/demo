package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Warehouses")
public class WarehouseEntity {
  public enum Family {
    EST,
    ROB
  }

  @Id
  @Column(columnDefinition = "bigint auto_increment")
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  @Column
  @GeneratedValue(generator = "uuid")
  private String uuid;

  @Column private String client;

  @Column private Family family;

  @Column private Long size;

  @OneToMany(mappedBy = "warehouse")
  private Set<RackEntity> racks;
}
