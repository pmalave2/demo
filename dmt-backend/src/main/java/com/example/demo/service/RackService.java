package com.example.demo.service;

import java.util.List;

import com.example.demo.controller.dto.RackCreateDTO;
import com.example.demo.controller.dto.RackDTO;
import com.example.demo.controller.dto.RackUpdateDTO;
import com.example.demo.exception.NoCompatibleRackException;

public interface RackService {
  RackDTO create(RackCreateDTO dto) throws NoCompatibleRackException;

  List<RackDTO> read();

  RackDTO update(Long id, RackUpdateDTO dto) throws NoCompatibleRackException;

  void delete(Long id);
}
