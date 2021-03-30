package com.jfb.workshopcassandra.controllers.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import com.jfb.workshopcassandra.services.exceptions.ResourceNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
    StandardError error = new StandardError();
    HttpStatus status = HttpStatus.BAD_REQUEST;
      error.setError("Not found");
      error.setMessage(e.getMessage());
      error.setPath(request.getRequestURI());
      error.setStatus(status.value());
      error.setTimestamp(Instant.now());
    return ResponseEntity.status(status).body(error);
  }
}
