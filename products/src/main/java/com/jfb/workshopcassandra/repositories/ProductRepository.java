package com.jfb.workshopcassandra.repositories;

import java.util.List;
import java.util.UUID;

import com.jfb.workshopcassandra.models.entities.Product;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CassandraRepository<Product, UUID> {

  @AllowFiltering
  List<Product> findByDepartment(String department);

  @Query("SELECT * FROM products WHERE description LIKE :text")
  List<Product> findByDescription(String text);

  /**
   * DEVE SER EXECUTADO NO CONSOLE DO CASSANDRA DENTRO DA KEYSPACE.
   * CREATE CUSTOM INDEX products_description_idx ON  products (description) USING 'org.apache.cassandra.index.sasi.SASIIndex' WITH OPTIONS = {'mode': 'CONTAINS', 'analyzer_class': 'org.apache.cassandra.index.sasi.analyzer.NonTokenizingAnalyzer','case_sensitive': 'false'};
  */
}
