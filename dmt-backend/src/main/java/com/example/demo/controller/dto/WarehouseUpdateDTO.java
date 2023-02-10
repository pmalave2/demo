package com.example.demo.controller.dto;

import com.example.demo.entity.WarehouseEntity.Family;

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
public class WarehouseUpdateDTO {
  @NotNull
  private Family family;

  @NotNull
  private Long size;
}
