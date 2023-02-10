package com.example.demo.controller.dto;

import com.example.demo.entity.RackEntity.Type;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class RackUpdateDTO {
  @NotNull
  private Type type;

  @NotNull
  private Long warehouseId;
}
