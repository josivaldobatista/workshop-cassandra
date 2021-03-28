package com.jfb.workshopcassandra.repositories;

import java.util.UUID;

import com.jfb.workshopcassandra.models.entities.Product;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CassandraRepository<Product, UUID> {
}
