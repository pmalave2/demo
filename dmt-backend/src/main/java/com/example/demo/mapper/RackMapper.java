package com.example.demo.mapper;

import java.util.Objects;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import com.example.demo.controller.dto.RackCreateDTO;
import com.example.demo.controller.dto.RackDTO;
import com.example.demo.entity.RackEntity;
import com.example.demo.entity.WarehouseEntity;

@Mapper
public interface RackMapper {
  RackMapper INSTANCE = Mappers.getMapper(RackMapper.class);

  RackEntity dtoToEntity(RackCreateDTO dto);

  @Mapping(target = "warehouseId", source = "warehouse", qualifiedByName = "getWarehouseId")
  RackDTO entityToDto(RackEntity entity);

  RackEntity entityToEntity(RackEntity entity);

  @Named("getWarehouseId")
  default Long getId(WarehouseEntity source) {
    if (Objects.isNull(source)) return null;

    return source.getId();
  }
}
