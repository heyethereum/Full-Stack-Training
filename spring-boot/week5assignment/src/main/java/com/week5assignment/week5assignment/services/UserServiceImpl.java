package com.week5assignment.week5assignment.services;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.week5assignment.week5assignment.model.User;

@Service
public class UserServiceImpl implements UserService {

  @Override
  public List<User> getallUsers() {
    List<User> response = new ArrayList<>();
    ObjectMapper mapper = new ObjectMapper();
    try {
      User[] users = mapper.readValue(new File("spring-boot/week5assignment/src/main/resources/static/users.json"),
          User[].class);
      response = Arrays.asList(users);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return response;
  }

  @Override
  public User findUser(User userRequest) {
    List<User> usersList = new ArrayList<>();
    String username = userRequest.getUsername();
    String password = userRequest.getPassword();

    try {
      ObjectMapper mapper = new ObjectMapper();
      User[] users = mapper.readValue(new File("spring-boot/week5assignment/src/main/resources/static/users.json"),
          User[].class);
      usersList = Arrays.asList(users);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return usersList.stream()
        .filter(user -> user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password))
        .findAny()
        .orElse(null);
  }

}
