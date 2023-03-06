package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RackEntity {
  public enum Type {
    A,
    B,
    C,
    D
  }

  @Id private String id;

  private String uuid;

  private Type type;

  private String warehouseId;
}
