package com.example.demo.service.impl;

import com.example.demo.controller.dto.RackCreateDTO;
import com.example.demo.controller.dto.RackDTO;
import com.example.demo.controller.dto.RackUpdateDTO;
import com.example.demo.entity.RackEntity;
import com.example.demo.entity.WarehouseEntity;
import com.example.demo.exception.NoCompatibleRackException;
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
    var entityWarehouse = warehouseRepository.getReferenceById(dto.getWarehouseId());

    if (Boolean.FALSE.equals(isCompatibleRack(entityWarehouse.getFamily(), entity.getType())))
      throw new NoCompatibleRackException();


    entity.setWarehouse(entityWarehouse);

    var entityPersisted = rackRepository.save(entity);

    return mapper.entityToDto(entityPersisted);
  }

  @Override
  public List<RackDTO> read() {
    return rackRepository.findAll().stream().map(mapper::entityToDto).toList();
  }

  @Override
  public RackDTO update(Long id, RackUpdateDTO dto) throws NoCompatibleRackException {
    var entity = rackRepository.getReferenceById(id);
    entity.setType(dto.getType());
    entity.setWarehouse(warehouseRepository.getReferenceById(id));

    if (Boolean.FALSE.equals(isCompatibleRack(entity.getWarehouse().getFamily(), entity.getType())))
      throw new NoCompatibleRackException();

    return mapper.entityToDto(rackRepository.save(entity));
  }

  @Override
  public void delete(Long id) {
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
