package com.jfb.workshopcassandra.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import com.jfb.workshopcassandra.models.dto.DepartmentDTO;
import com.jfb.workshopcassandra.models.entities.Department;
import com.jfb.workshopcassandra.repositories.DepartmentRepository;
import com.jfb.workshopcassandra.services.exceptions.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DepartmentService {

  @Autowired
  private DepartmentRepository repository;

  @Transactional(readOnly = true)
  public List<DepartmentDTO> findAll() {
    List<Department> list = repository.findAll();
    return list.stream().map(x -> new DepartmentDTO(x)).collect(Collectors.toList());
  }

  @Transactional(readOnly = true)
  public DepartmentDTO findById(UUID id) {
    Department entity = getById(id);
    return new DepartmentDTO(entity);
  }

  public DepartmentDTO insert(DepartmentDTO dto) {
    Department entity = new Department();
    entity.setId(UUID.randomUUID()); // <- Como o id não é auto gerado preciso setalo aqui.
    copyDtoToEntity(dto, entity);
    entity = repository.save(entity);
    return new DepartmentDTO(entity);
  }

  public DepartmentDTO update(UUID id, DepartmentDTO dto) {
    Department entity = getById(id);
    copyDtoToEntity(dto, entity);
    entity = repository.save(entity);
    return new DepartmentDTO(entity);
  }

  // MÉTODOS AUXILIARES
  private void copyDtoToEntity(DepartmentDTO dto, Department entity) {
    entity.setName(dto.getName());
  }

  private Department getById(UUID id) {
    Optional<Department> result = repository.findById(id);
    return result.orElseThrow(() -> new ResourceNotFoundException("Objeto não encontrado"));
  }
}
