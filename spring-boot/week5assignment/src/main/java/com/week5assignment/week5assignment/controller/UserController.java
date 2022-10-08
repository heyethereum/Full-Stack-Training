package com.week5assignment.week5assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.week5assignment.week5assignment.Request.NumberRequest;
import com.week5assignment.week5assignment.Response.GeneralResponse;
import com.week5assignment.week5assignment.model.User;
import com.week5assignment.week5assignment.services.MathServiceImpl;
import com.week5assignment.week5assignment.services.UserServiceImpl;

@RestController
@RequestMapping("/week5Assignment")
public class UserController {

  @Autowired
  UserServiceImpl userServiceImpl;
  @Autowired
  MathServiceImpl mathServiceImpl;

  @GetMapping("/getUsers")
  public ResponseEntity<List<User>> getUsers() {
    return ResponseEntity.ok(userServiceImpl.getallUsers());
  }

  @PostMapping("/number")
  public ResponseEntity<GeneralResponse> numberOperation(@RequestBody NumberRequest request) {
    GeneralResponse response = new GeneralResponse();

    String message = mathServiceImpl.calculate(request.getNum1(), request.getNum2(), request.getOperation());
    response.setMessage(message);

    return ResponseEntity.ok(response);
  }

  @PostMapping("/userLogin")
  public ResponseEntity<GeneralResponse> findUser(@RequestBody User userRequest) {
    GeneralResponse response = new GeneralResponse();

    User authenticateUser = userServiceImpl.findUser(userRequest);

    String message = (authenticateUser == null) ? "User not found or Wrong password" : "Login Success!";
    response.setMessage(message);

    return (authenticateUser == null) ? ResponseEntity.badRequest().body(response) : ResponseEntity.ok(response);
  }
}
