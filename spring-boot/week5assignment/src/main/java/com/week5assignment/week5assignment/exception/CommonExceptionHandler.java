package com.week5assignment.week5assignment.exception;

import java.io.FileNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.week5assignment.week5assignment.Response.GeneralResponse;

@ControllerAdvice
public class CommonExceptionHandler {
  @ExceptionHandler(Exception.class)
  public ResponseEntity<GeneralResponse> exceptionHandler(Exception e) {
    return ResponseEntity.badRequest().body(new GeneralResponse(e.getMessage()));
  }

  @ExceptionHandler(UnauthorizedException.class)
  public ResponseEntity<String> exceptionHandler(UnauthorizedException e) {
    return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
  }

  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity<GeneralResponse> exceptionHandler(RuntimeException e) {
    return ResponseEntity.badRequest().body(new GeneralResponse(e.getMessage()));
  }

  @ExceptionHandler(CustomException.class)
  public ResponseEntity<GeneralResponse> exceptionHandler(CustomException e) {
    return ResponseEntity.badRequest().body(new GeneralResponse(e.getMessage()));
  }

  @ExceptionHandler(NumberFormatException.class)
  public ResponseEntity<GeneralResponse> exceptionHandler(NumberFormatException e) {
    return ResponseEntity.badRequest().body(new GeneralResponse(e.getMessage()));
  }

  @ExceptionHandler(FileNotFoundException.class)
  public ResponseEntity<GeneralResponse> exceptionHandler(FileNotFoundException e) {
    return ResponseEntity.badRequest().body(new GeneralResponse("File Not found!"));
  }
}
