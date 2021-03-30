package com.jfb.workshopcassandra.services;

import java.util.Optional;
import java.util.UUID;

import com.jfb.workshopcassandra.models.dto.ProductDTO;
import com.jfb.workshopcassandra.models.entities.Product;
import com.jfb.workshopcassandra.repositories.ProductRepository;
import com.jfb.workshopcassandra.services.exceptions.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

  @Autowired
  private ProductRepository repository;

  @Transactional(readOnly = true)
  public ProductDTO findById(UUID id) {
    Product entity = getById(id);
    return new ProductDTO(entity);
  }

  private Product getById(UUID id) {
    Optional<Product> result = repository.findById(id);
    return result.orElseThrow(() -> new ResourceNotFoundException("Objeto não encontrado"));
  }

}
