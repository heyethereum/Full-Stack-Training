package com.week5assignment.week5assignment.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.week5assignment.week5assignment.Request.UserRequest;
import com.week5assignment.week5assignment.Response.GeneralResponse;
import com.week5assignment.week5assignment.exception.CustomException;
import com.week5assignment.week5assignment.model.User;
import com.week5assignment.week5assignment.model.UserModel;
import com.week5assignment.week5assignment.services.UserServiceImpl;

@RestController
@RequestMapping("/week5Assignment")
public class UserController {
  String folderPath = "spring-boot/week5assignment/src/main/java/com/week5assignment/week5assignment/userupload/";

  @Autowired
  UserServiceImpl userServiceImpl;

  @GetMapping("/userModel")
  public ResponseEntity<List<UserModel>> getUsers() throws Exception {
    return ResponseEntity.ok(userServiceImpl.getallUsers());
  }

  @GetMapping("/userModel/{userid}")
  public ResponseEntity<UserModel> getUserModel(@PathVariable String userid)
      throws NumberFormatException, CustomException {
    return ResponseEntity.ok(userServiceImpl.findUserModelById(Long.valueOf(userid)));
  }

  @GetMapping("/user/{userid}")
  public ResponseEntity<User> getUser(@PathVariable String userid) throws NumberFormatException, CustomException {
    return ResponseEntity.ok(userServiceImpl.findUserById(Long.valueOf(userid)));
  }

  @PostMapping("/userLoginParams")
  public ResponseEntity<User> loginWithParams(@RequestParam String email, @RequestParam String password)
      throws CustomException {

    return ResponseEntity.ok(userServiceImpl.findUserWithEmail(email, password));
  }

  @PostMapping("/userLogin")
  public ResponseEntity<GeneralResponse> findUser(@RequestBody User userRequest) {
    GeneralResponse response = userServiceImpl.findUser(userRequest.getUsername(), userRequest.getPassword());

    return (response.getMessage().contains("Success"))
        ? ResponseEntity.ok(response)
        : ResponseEntity.badRequest().body(response);
  }

  @PostMapping("/userModelLogin")
  public ResponseEntity<UserModel> userModelLogin(@RequestBody UserRequest userRequest) throws CustomException {
    return ResponseEntity.ok(userServiceImpl.userLogin(userRequest.getEmail(), userRequest.getPassword()));
  }

  @PostMapping("/userModelLogout")
  public ResponseEntity<GeneralResponse> userModelLogout(@RequestBody UserRequest userRequest) throws Exception {
    GeneralResponse response = new GeneralResponse();
    userServiceImpl.logout(userRequest.getId());
    response.setMessage("Logout success!");
    return ResponseEntity.ok(response);
  }

  @PostMapping("/userModelRegister")
  public ResponseEntity<GeneralResponse> userRegister(@RequestBody UserRequest userRequest) throws CustomException {
    GeneralResponse response = new GeneralResponse();
    userServiceImpl.createUser(userRequest);
    response.setMessage("Register success!");
    return ResponseEntity.ok(response);

  }

  @PostMapping("/userModelUpdate")
  public ResponseEntity<GeneralResponse> userUpdate(@RequestBody UserRequest userRequest) throws CustomException {
    GeneralResponse response = new GeneralResponse();
    userServiceImpl.updateUser(userRequest);
    response.setMessage("Update Success!");
    return ResponseEntity.ok(response);

  }

  @PostMapping("/userModelDelete")
  public ResponseEntity<GeneralResponse> userDelete(@RequestBody UserRequest userRequest) throws CustomException {
    GeneralResponse response = new GeneralResponse();
    userServiceImpl.deleteUser(userRequest.getId());
    response.setMessage("Deletion Success!");
    return ResponseEntity.ok(response);

  }

  @PostMapping(value = "/imageupload")
  public ResponseEntity<GeneralResponse> imageUpload(@RequestParam String userId, @RequestParam MultipartFile file,
      @RequestHeader("token") String token) throws CustomException, IOException {
    userServiceImpl.profilePicUpload(token, userId, file);
    GeneralResponse response = new GeneralResponse();
    response.setMessage("File uploaded: " + file.getOriginalFilename());
    return ResponseEntity.ok(response);
  }

  @GetMapping(value = "readImage/{fileName}", produces = MediaType.IMAGE_PNG_VALUE)
  public byte[] imageRequest(@PathVariable String fileName, @RequestHeader("token") String token)
      throws IOException, CustomException {
    return userServiceImpl.profilePicRequest(token, fileName);
  }
}
