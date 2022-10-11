package com.week5assignment.week5assignment.services;

import java.util.List;

import com.week5assignment.week5assignment.Response.GeneralResponse;
import com.week5assignment.week5assignment.exception.CustomException;
import com.week5assignment.week5assignment.model.User;

public interface UserService {
  List<User> getallUsers();

  User findUserById(long id) throws CustomException;

  User findUserWithEmail(String email, String password) throws CustomException;

  GeneralResponse findUser(String username, String password);
}
