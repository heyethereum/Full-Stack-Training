package com.week5assignment.week5assignment.model;

public class User {
  private long id;
  private String username;
  private String password;
  private String email;
  private String address;

  public User() {
    super();
  }

  public User(String username, String email, String address) {
    this.username = username;
    this.email = email;
    this.address = address;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

}
