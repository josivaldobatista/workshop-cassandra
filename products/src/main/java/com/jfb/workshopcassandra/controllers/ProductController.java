package com.jfb.workshopcassandra.controllers;

import java.util.UUID;

import com.jfb.workshopcassandra.models.dto.ProductDTO;
import com.jfb.workshopcassandra.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

  @Autowired
  private ProductService service;

  @GetMapping(value = "/{id}")
  public ResponseEntity<ProductDTO> findById(@PathVariable UUID id) {
    ProductDTO obj = service.findById(id);
    return ResponseEntity.ok().body(obj);
  }
  
}