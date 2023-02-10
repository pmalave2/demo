package com.example.demo.mapper;

import com.example.demo.controller.dto.WarehouseCreateDTO;
import com.example.demo.controller.dto.WarehouseDTO;
import com.example.demo.entity.WarehouseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WarehouseMapper {
  WarehouseMapper INSTANCE = Mappers.getMapper(WarehouseMapper.class);

  WarehouseEntity dtoToEntity(WarehouseCreateDTO dto);

  WarehouseDTO entityToDto(WarehouseEntity entity);

  WarehouseEntity entityToEntity(WarehouseEntity entity);
}
