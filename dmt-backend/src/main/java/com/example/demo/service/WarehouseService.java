package com.example.demo.service;

import com.example.demo.controller.dto.WarehouseCreateDTO;
import com.example.demo.controller.dto.WarehouseDTO;
import com.example.demo.controller.dto.WarehouseUpdateDTO;
import java.util.List;

public interface WarehouseService {
  WarehouseDTO create(WarehouseCreateDTO dto);

  List<WarehouseDTO> read();

  WarehouseDTO readById(String id);

  WarehouseDTO update(String id, WarehouseUpdateDTO dto);

  void delete(String id);

  List<List<String>> permutate(String id);
}
