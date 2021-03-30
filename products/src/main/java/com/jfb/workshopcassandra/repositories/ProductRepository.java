package com.jfb.workshopcassandra.repositories;

import java.util.List;
import java.util.UUID;

import com.jfb.workshopcassandra.models.entities.Product;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CassandraRepository<Product, UUID> {

  @AllowFiltering
  List<Product> findByDepartment(String department);
}
