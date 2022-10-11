package com.week5assignment.week5assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.week5assignment.week5assignment.Response.GeneralResponse;
import com.week5assignment.week5assignment.model.User;
import com.week5assignment.week5assignment.services.UserServiceImpl;

@RestController
@RequestMapping("/week5Assignment")
public class UserController {

  @Autowired
  UserServiceImpl userServiceImpl;

  @GetMapping("/getUsers")
  public ResponseEntity<List<User>> getUsers() {
    return ResponseEntity.ok(userServiceImpl.getallUsers());
  }

  @GetMapping("/user/{userid}")
  public ResponseEntity<Object> getUser(@PathVariable Long userid) {
    try {
      return ResponseEntity.ok(userServiceImpl.findUserById(userid));
    } catch (Exception e) {
      GeneralResponse response = new GeneralResponse();
      response.setMessage(e.getMessage());
      return ResponseEntity.badRequest().body(response);
    }
  }

  @PostMapping("/userLoginParams")
  public ResponseEntity<Object> loginWithParams(@RequestParam String email, @RequestParam String password) {
    try {
      return ResponseEntity.ok(userServiceImpl.findUserWithEmail(email, password));
    } catch (Exception e) {
      GeneralResponse response = new GeneralResponse();
      response.setMessage(e.getMessage());
      return ResponseEntity.badRequest().body(response);
    }
  }

  @PostMapping("/userLogin")
  public ResponseEntity<GeneralResponse> findUser(@RequestBody User userRequest) {
    GeneralResponse response = userServiceImpl.findUser(userRequest.getUsername(), userRequest.getPassword());

    return (response.getMessage().contains("Success"))
        ? ResponseEntity.ok(response)
        : ResponseEntity.badRequest().body(response);
  }
}
