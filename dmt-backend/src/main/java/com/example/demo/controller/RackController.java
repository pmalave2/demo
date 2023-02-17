package com.example.demo.controller;

import com.example.demo.controller.dto.RackCreateDTO;
import com.example.demo.controller.dto.RackDTO;
import com.example.demo.controller.dto.RackUpdateDTO;
import com.example.demo.exception.NoCompatibleRackException;
import com.example.demo.service.RackService;
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
@RequestMapping("/api/racks")
public class RackController {
  private final RackService service;

  @CrossOrigin
  @PostMapping
  public RackDTO create(@RequestBody @Validated RackCreateDTO dto)
      throws NoCompatibleRackException {
    return service.create(dto);
  }

  @CrossOrigin
  @GetMapping
  public List<RackDTO> read() {
    return service.read();
  }

  @PutMapping(path = "/{id}")
  public RackDTO update(
      @PathVariable(required = true) Long id, @RequestBody @Validated RackUpdateDTO dto)
      throws NoCompatibleRackException {
    return service.update(id, dto);
  }

  @DeleteMapping(path = "/{id}")
  public void delete(@PathVariable(required = true) Long id) {
    service.delete(id);
  }
}
