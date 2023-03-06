package com.example.demo.repository;

import com.example.demo.entity.WarehouseEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WarehouseRepository extends MongoRepository<WarehouseEntity, String> {}
