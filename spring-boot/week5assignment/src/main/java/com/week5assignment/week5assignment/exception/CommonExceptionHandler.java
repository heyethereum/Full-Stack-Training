package com.week5assignment.week5assignment.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.week5assignment.week5assignment.Response.GeneralResponse;

@ControllerAdvice
public class CommonExceptionHandler {
  @ExceptionHandler(Exception.class)
  public ResponseEntity<GeneralResponse> exceptionHandler(Exception e) {
    GeneralResponse response = new GeneralResponse();
    response.setMessage(e.getMessage());
    return ResponseEntity.badRequest().body(response);
  }

  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity<GeneralResponse> exceptionHandler(RuntimeException e) {
    GeneralResponse response = new GeneralResponse();
    response.setMessage(e.getMessage());
    return ResponseEntity.badRequest().body(response);
  }

  @ExceptionHandler(CustomException.class)
  public ResponseEntity<GeneralResponse> exceptionHandler(CustomException e) {
    GeneralResponse response = new GeneralResponse();
    response.setMessage(e.getMessage());
    return ResponseEntity.badRequest().body(response);
  }

  @ExceptionHandler(NumberFormatException.class)
  public ResponseEntity<GeneralResponse> exceptionHandler(NumberFormatException e) {
    GeneralResponse response = new GeneralResponse();
    response.setMessage(e.getMessage());
    return ResponseEntity.badRequest().body(response);
  }
}
