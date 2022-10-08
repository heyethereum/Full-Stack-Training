package com.week5assignment.week5assignment.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.week5assignment.week5assignment.Response.GeneralResponse;
import com.week5assignment.week5assignment.model.User;

@Service
public class UserServiceImpl implements UserService {

  @Override
  public List<User> getallUsers() {
    Database db = new Database();
    return db.getData();
  }

  @Override
  public GeneralResponse findUser(String username, String password) {
    Database db = new Database();
    List<User> usersList = db.getData();

    User authenticateUser = usersList.stream()
        .filter(user -> user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password))
        .findAny()
        .orElse(null);

    String message = (authenticateUser == null) ? "User not found or Wrong password" : "Login Success!";
    GeneralResponse response = new GeneralResponse();
    response.setMessage(message);

    return response;
  }

}
