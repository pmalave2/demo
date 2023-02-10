package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
@Table(name = "Racks")
public class RackEntity {
  public enum Type {
    A,
    B,
    C,
    D
  }

  @Id
  @Column(columnDefinition = "bigint auto_increment")
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  @Column
  @GeneratedValue(generator = "uuid")
  private String uuid;

  @Column private Type type;

  @ManyToOne private WarehouseEntity warehouse;
}
