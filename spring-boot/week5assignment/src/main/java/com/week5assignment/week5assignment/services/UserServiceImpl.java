package com.week5assignment.week5assignment.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.week5assignment.week5assignment.Response.GeneralResponse;
import com.week5assignment.week5assignment.model.User;

@Service
public class UserServiceImpl implements UserService {

  @Override
  public List<User> getallUsers() {
    return Database.getData();
  }

  @Override
  public GeneralResponse findUser(String username, String password) {
    List<User> usersList = Database.getData();

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
