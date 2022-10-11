package com.week5assignment.week5assignment.services;

import java.util.List;

import com.week5assignment.week5assignment.Response.GeneralResponse;
import com.week5assignment.week5assignment.model.User;

public interface UserService {
  List<User> getallUsers();

  User findUserById(long id) throws Exception;

  User findUserWithEmail(String email, String password) throws Exception;

  GeneralResponse findUser(String username, String password);
}
