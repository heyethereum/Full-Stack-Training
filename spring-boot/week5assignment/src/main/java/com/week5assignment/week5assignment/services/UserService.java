package com.week5assignment.week5assignment.services;

import java.util.List;

import com.week5assignment.week5assignment.Request.UserRequest;
import com.week5assignment.week5assignment.Response.GeneralResponse;
import com.week5assignment.week5assignment.exception.CustomException;
import com.week5assignment.week5assignment.model.User;
import com.week5assignment.week5assignment.model.UserModel;

public interface UserService {
  List<UserModel> getallUsers();

  UserModel findUserModelById(long id) throws CustomException;

  User findUserById(long id) throws CustomException;

  User findUserWithEmail(String email, String password) throws CustomException;

  GeneralResponse findUser(String username, String password);

  boolean createUser(UserRequest userRequest) throws CustomException;

  UserModel userLogin(String email, String password) throws CustomException;

  boolean updateUser(UserRequest userRequest) throws CustomException;

  boolean deleteUser(Long id) throws CustomException;

  boolean validateToken(String token, Long id) throws CustomException;

  boolean logout(Long id) throws Exception;
}
