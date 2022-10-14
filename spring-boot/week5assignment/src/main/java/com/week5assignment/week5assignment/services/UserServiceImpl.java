package com.week5assignment.week5assignment.services;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.core.env.Environment;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.week5assignment.week5assignment.Request.UserRequest;
import com.week5assignment.week5assignment.Response.GeneralResponse;
import com.week5assignment.week5assignment.exception.CustomException;
import com.week5assignment.week5assignment.model.User;
import com.week5assignment.week5assignment.model.UserModel;
import com.week5assignment.week5assignment.repo.UserRepo;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class UserServiceImpl implements UserService {
  String folderPath = "spring-boot/week5assignment/src/main/java/com/week5assignment/week5assignment/userupload/";
  @Autowired
  Environment env;
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

    return new GeneralResponse(message);
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
    String token = generateToken(user);
    updateToken(token, user.getId());
    user.setToken(token);
    return user;
  }

  private Integer updateToken(String token, Long id) {
    System.out.println(token + " " + id);
    return userRepo.updateTokenForUserId(token, id);
  }

  private String generateToken(UserModel user) {
    Calendar c = Calendar.getInstance();
    c.add(Calendar.DAY_OF_YEAR, 10);
    // c.add(Calendar.SECOND, 5);
    return Jwts.builder()
        .claim("email", user.getEmail())
        .setSubject(user.getName())
        .setId("" + user.getId())
        .setIssuedAt(new Date())
        .setExpiration(c.getTime())
        .signWith(SignatureAlgorithm.HS512, env.getProperty("JWT_SECRET"))
        .compact();
  }

  public Jws<Claims> checkJWTToken(String token) throws CustomException {
    return Jwts.parser().setSigningKey(env.getProperty("JWT_SECRET")).parseClaimsJws(token);
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
  public Integer logout(Long id) {
    return updateToken("", id);
  }

  @Override
  public Integer profilePicUpload(String token, MultipartFile file) throws CustomException, IOException {
    Jws<Claims> claim = checkJWTToken(token);
    Long claimIdFromToken = Long.valueOf((String) claim.getBody().get("jti"));
    validateToken(token, claimIdFromToken);

    String fileName = claimIdFromToken + "_" + file.getOriginalFilename();

    try (FileOutputStream out = new FileOutputStream(folderPath + fileName)) {
      out.write(file.getBytes());
    } catch (IOException e) {
      throw new CustomException(e.getMessage());
    }
    return userRepo.updateProfilepicForUserId(fileName, claimIdFromToken);
  }

  @Override
  public byte[] profilePicRequest(String token, String fileName) throws IOException, CustomException {
    String claimIdFromToken = (String) checkJWTToken(token).getBody().get("jti");
    FileInputStream input = new FileInputStream(folderPath + claimIdFromToken + "_" + fileName);

    return IOUtils.toByteArray(input);
  }
}
