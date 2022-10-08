package com.week5assignment.week5assignment.services;

import java.util.List;

import com.week5assignment.week5assignment.Response.GeneralResponse;
import com.week5assignment.week5assignment.model.User;

public interface UserService {
  List<User> getallUsers();

  GeneralResponse findUser(String username, String password);
}
