package com.jfb.workshopcassandra.controllers;

import java.util.List;
import java.util.UUID;

import com.jfb.workshopcassandra.models.dto.DepartmentDTO;
import com.jfb.workshopcassandra.services.DepartmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/departments")
public class DepartmentController {

  @Autowired
  private DepartmentService service;

  @GetMapping
  public ResponseEntity<List<DepartmentDTO>> findAll() {
    List<DepartmentDTO> list = service.findAll();
    return ResponseEntity.ok().body(list);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<DepartmentDTO> findById(@PathVariable UUID id) {
    DepartmentDTO obj = service.findById(id);
    return ResponseEntity.ok().body(obj);
  }
}
