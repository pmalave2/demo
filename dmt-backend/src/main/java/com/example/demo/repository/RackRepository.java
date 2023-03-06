package com.example.demo.repository;

import com.example.demo.entity.RackEntity;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RackRepository extends MongoRepository<RackEntity, String> {
  List<RackEntity> findAllByWarehouseId(String id);
}
