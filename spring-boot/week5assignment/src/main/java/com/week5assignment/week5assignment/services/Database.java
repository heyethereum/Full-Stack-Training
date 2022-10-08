package com.week5assignment.week5assignment.services;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.week5assignment.week5assignment.model.User;

public class Database {
  private Database() {
  }

  public static List<User> getData() {
    List<User> response = new ArrayList<>();
    try {
      ObjectMapper mapper = new ObjectMapper();
      User[] users = mapper.readValue(
          new File("spring-boot/week5assignment/src/main/resources/static/users.json"),
          User[].class);
      response = Arrays.asList(users);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return response;
  }
}
