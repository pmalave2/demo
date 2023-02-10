package com.example.demo.mapper;


import com.example.demo.controller.dto.RackCreateDTO;
import com.example.demo.controller.dto.RackDTO;
import com.example.demo.entity.RackEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RackMapper {
  RackMapper INSTANCE = Mappers.getMapper(RackMapper.class);

  RackEntity dtoToEntity(RackCreateDTO dto);

  @Mapping(target = "warehouseId", source = "warehouse.id")
  RackDTO entityToDto(RackEntity entity);

  RackEntity entityToEntity(RackEntity entity);
}
