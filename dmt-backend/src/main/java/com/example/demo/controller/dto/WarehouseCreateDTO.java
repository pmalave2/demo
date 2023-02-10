package com.example.demo.controller.dto;

import org.hibernate.validator.constraints.UUID;

import jakarta.validation.constraints.NotEmpty;
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
public class WarehouseCreateDTO extends WarehouseUpdateDTO {
  @UUID
  @NotEmpty
  private String uuid;

  @NotEmpty
  private String client;
}
