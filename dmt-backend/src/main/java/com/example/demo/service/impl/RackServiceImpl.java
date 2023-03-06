package com.example.demo.service.impl;

import com.example.demo.controller.dto.RackCreateDTO;
import com.example.demo.controller.dto.RackDTO;
import com.example.demo.controller.dto.RackUpdateDTO;
import com.example.demo.entity.RackEntity;
import com.example.demo.entity.WarehouseEntity;
import com.example.demo.exception.NoCompatibleRackException;
import com.example.demo.exception.NoFoundRackException;
import com.example.demo.exception.NoFoundWarehouseException;
import com.example.demo.mapper.RackMapper;
import com.example.demo.repository.RackRepository;
import com.example.demo.repository.WarehouseRepository;
import com.example.demo.service.RackService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RackServiceImpl implements RackService {

  private final RackRepository rackRepository;
  private static final RackMapper mapper = RackMapper.INSTANCE;
  private final WarehouseRepository warehouseRepository;

  @Override
  public RackDTO create(RackCreateDTO dto) throws NoCompatibleRackException {
    var entity = mapper.dtoToEntity(dto);
    var entityWarehouseOptional = warehouseRepository.findById(dto.getWarehouseId());

    if (!entityWarehouseOptional.isPresent()) throw new NoFoundWarehouseException();

    var entityWarehouse = entityWarehouseOptional.get();

    if (Boolean.FALSE.equals(isCompatibleRack(entityWarehouse.getFamily(), entity.getType())))
      throw new NoCompatibleRackException();

    entity.setWarehouseId(entityWarehouse.getId());

    var entityPersisted = rackRepository.save(entity);

    return mapper.entityToDto(entityPersisted);
  }

  @Override
  public List<RackDTO> read() {
    return rackRepository.findAll().stream().map(mapper::entityToDto).toList();
  }

  @Override
  public RackDTO update(String id, RackUpdateDTO dto) throws NoCompatibleRackException {
    var entityOptional = rackRepository.findById(id);
    var entityWarehouseOptional = warehouseRepository.findById(dto.getWarehouseId());

    if (!entityOptional.isPresent()) throw new NoFoundRackException();

    if (!entityWarehouseOptional.isPresent()) throw new NoFoundWarehouseException();

    var entity = entityOptional.get();
    entity.setType(dto.getType());
    entity.setWarehouseId(entityWarehouseOptional.get().getId());

    if (Boolean.FALSE.equals(
        isCompatibleRack(entityWarehouseOptional.get().getFamily(), entity.getType())))
      throw new NoCompatibleRackException();

    return mapper.entityToDto(rackRepository.save(entity));
  }

  @Override
  public void delete(String id) {
    rackRepository.deleteById(id);
  }

  private Boolean isCompatibleRack(WarehouseEntity.Family family, RackEntity.Type rackType) {
    return (WarehouseEntity.Family.EST.equals(family)
            && (RackEntity.Type.A.equals(rackType)
                || RackEntity.Type.B.equals(rackType)
                || RackEntity.Type.C.equals(rackType)))
        || (WarehouseEntity.Family.ROB.equals(family)
            && (RackEntity.Type.A.equals(rackType)
                || RackEntity.Type.B.equals(rackType)
                || RackEntity.Type.D.equals(rackType)));
  }
}
