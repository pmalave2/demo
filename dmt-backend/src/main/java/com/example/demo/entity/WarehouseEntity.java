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
public class WarehouseEntity {
  public enum Family {
    EST,
    ROB
  }

  @Id private String id;

  private String uuid;

  private String client;

  private Family family;

  private Long size;
}
