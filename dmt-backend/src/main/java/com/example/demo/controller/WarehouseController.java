package com.example.demo.controller;

import com.example.demo.controller.dto.WarehouseCreateDTO;
import com.example.demo.controller.dto.WarehouseDTO;
import com.example.demo.controller.dto.WarehouseUpdateDTO;
import com.example.demo.service.WarehouseService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/warehouses")
public class WarehouseController {
  private final WarehouseService service;

  @CrossOrigin
  @PostMapping
  public WarehouseDTO create(@RequestBody @Validated WarehouseCreateDTO dto) {
    return service.create(dto);
  }

  @CrossOrigin
  @GetMapping
  public List<WarehouseDTO> read() {
    return service.read();
  }

  @CrossOrigin
  @GetMapping(path = "/{id}")
  public WarehouseDTO readById(@PathVariable(required = true) String id) {
    return service.readById(id);
  }

  @CrossOrigin
  @PutMapping(path = "/{id}")
  public WarehouseDTO update(
      @PathVariable(required = true) String id, @RequestBody @Validated WarehouseUpdateDTO dto) {
    return service.update(id, dto);
  }

  @CrossOrigin
  @DeleteMapping(path = "/{id}")
  public void delete(@PathVariable(required = true) String id) {
    service.delete(id);
  }

  @GetMapping(path = "/{id}/permutate")
  public List<List<String>> permutate(@PathVariable(required = true) String id) {
    return service.permutate(id);
  }
}
