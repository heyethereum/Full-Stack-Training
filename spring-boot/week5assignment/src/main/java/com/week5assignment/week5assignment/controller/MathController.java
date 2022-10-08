package com.week5assignment.week5assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.week5assignment.week5assignment.Request.NumberRequest;
import com.week5assignment.week5assignment.Response.GeneralResponse;
import com.week5assignment.week5assignment.services.MathServiceImpl;

@RestController
@RequestMapping("/week5Assignment")
public class MathController {
  @Autowired
  MathServiceImpl mathServiceImpl;

  @PostMapping("/number")
  public ResponseEntity<GeneralResponse> numberOperation(@RequestBody NumberRequest request) {
    GeneralResponse response = new GeneralResponse();

    String message = mathServiceImpl.calculate(request.getNum1(), request.getNum2(), request.getOperation());
    response.setMessage(message);

    return ResponseEntity.ok(response);
  }
}
