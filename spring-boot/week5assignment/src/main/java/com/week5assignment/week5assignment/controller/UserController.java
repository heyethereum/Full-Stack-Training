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

import com.week5assignment.week5assignment.Request.UserRequest;
import com.week5assignment.week5assignment.Response.GeneralResponse;
import com.week5assignment.week5assignment.model.User;
import com.week5assignment.week5assignment.model.UserModel;
import com.week5assignment.week5assignment.services.UserServiceImpl;

@RestController
@RequestMapping("/week5Assignment")
public class UserController {

  @Autowired
  UserServiceImpl userServiceImpl;

  @PostMapping("/userModel")
  public ResponseEntity<List<UserModel>> getUsers() {
    try {
      return ResponseEntity.ok(userServiceImpl.getallUsers());
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  @PostMapping("/userModel/{userid}")
  public ResponseEntity<Object> getUserModel(@PathVariable String userid) {
    GeneralResponse response = new GeneralResponse();
    try {
      return ResponseEntity.ok(userServiceImpl.findUserModelById(Long.valueOf(userid)));
    } catch (NumberFormatException e) {
      response.setMessage("Invalid User ID");
    } catch (Exception e) {
      response.setMessage(e.getMessage());
    }
    return ResponseEntity.badRequest().body(response);
  }

  @GetMapping("/user/{userid}")
  public ResponseEntity<Object> getUser(@PathVariable String userid) {
    GeneralResponse response = new GeneralResponse();
    try {
      return ResponseEntity.ok(userServiceImpl.findUserById(Long.valueOf(userid)));
    } catch (NumberFormatException e) {
      response.setMessage("Invalid User ID");
    } catch (Exception e) {
      response.setMessage(e.getMessage());
    }
    return ResponseEntity.badRequest().body(response);
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

  @PostMapping("/userModelLogin")
  public ResponseEntity<Object> userModelLogin(@RequestBody UserRequest userRequest) {
    try {
      return ResponseEntity.ok(userServiceImpl.userLogin(userRequest.getEmail(), userRequest.getPassword()));
    } catch (Exception e) {
      GeneralResponse response = new GeneralResponse();
      response.setMessage(e.getMessage());
      return ResponseEntity.badRequest().body(response);
    }
  }

  @PostMapping("/userModelRegister")
  public ResponseEntity<GeneralResponse> userRegister(@RequestBody UserRequest userRequest) {
    GeneralResponse response = new GeneralResponse();
    try {
      userServiceImpl.createUser(userRequest);
      response.setMessage("Register success!");
      return ResponseEntity.ok(response);
    } catch (Exception e) {
      response.setMessage(e.getMessage());
      return ResponseEntity.badRequest().body(response);
    }
  }

  @PostMapping("/userModelUpdate")
  public ResponseEntity<GeneralResponse> userUpdate(@RequestBody UserRequest userRequest) {
    GeneralResponse response = new GeneralResponse();
    try {
      userServiceImpl.updateUser(userRequest);
      response.setMessage("Update Success!");
      return ResponseEntity.ok(response);
    } catch (Exception e) {
      response.setMessage(e.getMessage());
      return ResponseEntity.badRequest().body(response);
    }
  }

  @PostMapping("/userModelDelete")
  public ResponseEntity<GeneralResponse> userDelete(@RequestBody UserRequest userRequest) {
    GeneralResponse response = new GeneralResponse();
    try {
      userServiceImpl.deleteUser(userRequest.getId());
      response.setMessage("Deletion Success!");
      return ResponseEntity.ok(response);
    } catch (Exception e) {
      response.setMessage(e.getMessage());
      return ResponseEntity.badRequest().body(response);
    }
  }
}
