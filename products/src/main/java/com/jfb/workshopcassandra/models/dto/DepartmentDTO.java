package com.jfb.workshopcassandra.models.dto;

import java.util.UUID;

import com.jfb.workshopcassandra.models.entities.Department;

public class DepartmentDTO {

  private UUID id;
  private String name;

  public DepartmentDTO() {
  }

  public DepartmentDTO(UUID id, String name) {
    this.id = id;
    this.name = name;
  }

  public DepartmentDTO(Department entity) {
    id = entity.getId();
    name = entity.getName();
  }

  public UUID getId() {
    return this.id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
