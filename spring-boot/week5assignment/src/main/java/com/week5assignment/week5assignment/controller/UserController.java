package com.week5assignment.week5assignment.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.week5assignment.week5assignment.Request.UserRequest;
import com.week5assignment.week5assignment.Response.GeneralResponse;
import com.week5assignment.week5assignment.exception.CustomException;
import com.week5assignment.week5assignment.model.User;
import com.week5assignment.week5assignment.model.UserModel;
import com.week5assignment.week5assignment.services.UserServiceImpl;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

@RestController
@RequestMapping("/week5Assignment")
public class UserController {
  @Autowired
  UserServiceImpl userServiceImpl;

  @Autowired
  RestTemplate restTemplate;

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
  public ResponseEntity<UserModel> userModelLogin(@RequestBody UserRequest userRequest, HttpServletResponse response)
      throws CustomException {
    UserModel user = userServiceImpl.userLogin(userRequest.getEmail(), userRequest.getPassword());

    Cookie cookie = new Cookie("token", user.getToken());
    cookie.setMaxAge(24 * 60 * 60);
    cookie.setSecure(true);
    cookie.setHttpOnly(true);
    cookie.setPath("/");
    response.addCookie(cookie);

    return ResponseEntity.ok(user);
  }

  @PostMapping("/userModelLogout")
  public ResponseEntity<GeneralResponse> userModelLogout(@RequestHeader("token") String token) throws CustomException {
    Long id = userServiceImpl.getIdByToken(token);
    userServiceImpl.logout(id);
    return ResponseEntity.ok(new GeneralResponse("Logout success!"));
  }

  @PostMapping("/userModelRegister")
  public ResponseEntity<GeneralResponse> userRegister(@RequestBody UserRequest userRequest) throws CustomException {
    userServiceImpl.createUser(userRequest);
    return ResponseEntity.ok(new GeneralResponse("Register success!"));

  }

  @PostMapping("/userModelUpdate")
  public ResponseEntity<GeneralResponse> userUpdate(@RequestBody UserRequest userRequest) throws CustomException {
    userServiceImpl.updateUser(userRequest);
    return ResponseEntity.ok(new GeneralResponse("Update Success!"));
  }

  @PostMapping("/userModelDelete")
  public ResponseEntity<GeneralResponse> userDelete(@RequestBody UserRequest userRequest) throws CustomException {
    userServiceImpl.deleteUser(userRequest.getId());
    return ResponseEntity.ok(new GeneralResponse("Deletion Success!"));
  }

  @PostMapping("/imageupload")
  public ResponseEntity<GeneralResponse> imageUpload(@RequestParam MultipartFile file,
      @RequestHeader("token") String token) throws CustomException, IOException {
    Long userId = userServiceImpl.getIdByToken(token);
    userServiceImpl.profilePicUpload(userId, file);
    return ResponseEntity.ok(new GeneralResponse("File uploaded: " + file.getOriginalFilename()));
  }

  // user only able to request image of own uploads
  @GetMapping(value = "readImage/{fileName}", produces = MediaType.IMAGE_PNG_VALUE)
  public byte[] imageRequest(@PathVariable String fileName, @RequestHeader("token") String token)
      throws IOException, CustomException {
    String userId = String.valueOf(userServiceImpl.getIdByToken(token));
    return userServiceImpl.getImageById(userId, fileName);
  }

  @GetMapping(value = "/readImage/{id}/{fileName}", produces = MediaType.IMAGE_PNG_VALUE)
  public byte[] imagebyId(@PathVariable String id, @PathVariable String fileName)
      throws IOException, CustomException {
    return userServiceImpl.getImageById(id, fileName);
  }

  @GetMapping("/listPartyAPI")
  public ResponseEntity<?> getUsersFrom3rdPartyAPI() throws Exception {
    try {
      HttpHeaders headers = new HttpHeaders();
      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
      headers.add("user-agent", "Application");
      // headers.add("auth-token", "some-bearer-token");
      HttpEntity<String> entity = new HttpEntity<String>(headers);

      String response = restTemplate.exchange("https://reqres.in/api/users?page=2", HttpMethod.GET, entity,
          String.class).getBody();
      Gson g = new Gson();
      JSONObject p = g.fromJson(response, JSONObject.class);
      System.out.println(p);
      System.out.println(p.get("data")); // array
      // TODO:: check how to iterate this array and extract the value
      // System.out.println(data);

      // JSONArray ar = (JSONArray) p.get("data");
      // System.out.println(ar);

      // System.out.println(response.getData());
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}
