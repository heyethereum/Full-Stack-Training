package com.week5assignment.week5assignment.services;

import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.week5assignment.week5assignment.Request.UserRequest;
import com.week5assignment.week5assignment.Response.GeneralResponse;
import com.week5assignment.week5assignment.exception.CustomException;
import com.week5assignment.week5assignment.model.User;
import com.week5assignment.week5assignment.model.UserModel;
import com.week5assignment.week5assignment.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
  UserRepo userRepo;

  @Override
  public List<UserModel> getallUsers() {
    return userRepo.findAll();
  }

  @Override
  public UserModel findUserModelById(long id) throws CustomException {
    return userRepo.findById(id).orElseThrow(() -> new CustomException("User not found!"));
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

  @Override
  public User findUserById(long id) throws CustomException {
    List<User> userList = Database.getData();
    HashMap<Long, User> userHashMap = new HashMap<>();
    userList.forEach(user -> userHashMap.put(user.getId(), user));

    if (!userHashMap.containsKey(id))
      throw new CustomException("User not found!");

    return userHashMap.get(id);
  }

  @Override
  public User findUserWithEmail(String email, String password) throws CustomException {
    List<User> usersList = Database.getData();
    return usersList.stream()
        .filter(user -> user.getEmail().equalsIgnoreCase(email) && user.getPassword().equals(password))
        .findAny()
        .orElseThrow(() -> new CustomException("User not found or Incorrect password!"));
  }

  @Override
  public boolean createUser(UserRequest userRequest) throws CustomException {
    Optional<UserModel> email = userRepo.getUserByEmail(userRequest.getEmail());
    if (email.isPresent())
      throw new CustomException("Email already exists");

    UserModel newUser = new UserModel();
    newUser.setName(userRequest.getName());
    newUser.setEmail(userRequest.getEmail());
    newUser.setPhone(userRequest.getPhone());
    newUser.setAddress(userRequest.getAddress());
    newUser.setPassword(userRequest.getPassword());
    userRepo.save(newUser);

    return true;
  }

  @Override
  public UserModel userLogin(String email, String password) throws CustomException {
    UserModel user = userRepo.getUserByEmailAndPassword(email, password)
        .orElseThrow(() -> new CustomException("Wrong email or password!"));
    String token = generateToken(user.getEmail());
    updateToken(token, user.getId());
    user.setToken(token);
    return user;
  }

  private void updateToken(String token, Long id) {
    System.out.println(token + " " + id);
    userRepo.updateTokenForUserId(token, id);
  }

  private String generateToken(String email) {
    String encodedEmail = Base64.getEncoder().encodeToString(email.getBytes());

    return encodedEmail + System.currentTimeMillis();
  }

  @Override
  public boolean updateUser(UserRequest userRequest) throws CustomException {
    UserModel user = userRepo.findById(userRequest.getId())
        .orElseThrow(() -> new CustomException("No User Found!"));
    if (userRequest.getEmail() != null && !userRequest.getEmail().equals(""))
      user.setEmail(userRequest.getEmail());
    if (userRequest.getPhone() != null && !userRequest.getPhone().equals(""))
      user.setPhone(userRequest.getPhone());
    if (userRequest.getName() != null && !userRequest.getName().equals(""))
      user.setName(userRequest.getName());
    if (userRequest.getAddress() != null && !userRequest.getAddress().equals(""))
      user.setAddress(userRequest.getAddress());
    if (userRequest.getPassword() != null && !userRequest.getPassword().equals(""))
      user.setPassword(userRequest.getPassword());

    userRepo.save(user);

    return true;
  }

  @Override
  public boolean deleteUser(Long id) throws CustomException {
    UserModel user = userRepo.findById(id).orElseThrow(() -> new CustomException("User Not Found!"));
    userRepo.delete(user);

    return true;
  }

  @Override
  public boolean validateToken(String token, Long id) throws CustomException {
    UserModel user = findUserModelById(id);
    if (!user.getToken().equals(token))
      throw new CustomException("Token mismatch");
    return true;
  }

  @Override
  public boolean logout(Long id) throws Exception {
    updateToken("", id);
    return true;
  }
}
