package com.example.demo.repository;

import com.example.demo.entity.RackEntity;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RackRepository extends JpaRepository<RackEntity, Long> {
  @EntityGraph(attributePaths = "warehouse")
  RackEntity getReferenceById(Long id);
}
