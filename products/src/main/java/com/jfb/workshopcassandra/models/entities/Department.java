package com.jfb.workshopcassandra.models.entities;

import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table(value = "departments")
public class Department {

  @PrimaryKey
  private UUID id;

  private String name;

  public Department() {
  }

  public Department(UUID id, String name) {
    this.id = id;
    this.name = name;
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
