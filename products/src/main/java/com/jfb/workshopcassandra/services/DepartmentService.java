package com.jfb.workshopcassandra.services;

import java.util.List;
import java.util.stream.Collectors;

import com.jfb.workshopcassandra.models.dto.DepartmentDTO;
import com.jfb.workshopcassandra.models.entities.Department;
import com.jfb.workshopcassandra.repositories.DepartmentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

  @Autowired
  private DepartmentRepository repository;

  public List<DepartmentDTO> findAll() {
    List<Department> list = repository.findAll();
    return list.stream().map(x -> new DepartmentDTO(x)).collect(Collectors.toList());
  }
}
