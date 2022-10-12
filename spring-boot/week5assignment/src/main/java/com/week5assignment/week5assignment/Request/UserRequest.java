package com.week5assignment.week5assignment.Request;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserRequest {
  private long id;
  private String name;
  private String password;
  private String email;
  private String address;
  private String phone;

  public UserRequest(long id, String name, String password, String email, String address, String phone) {
    this.id = id;
    this.name = name;
    this.password = password;
    this.email = email;
    this.address = address;
    this.phone = phone;
  }

  public UserRequest(String name, String password, String email, String address, String phone) {
    this.name = name;
    this.password = password;
    this.email = email;
    this.address = address;
    this.phone = phone;
  }

  public UserRequest() {
    super();
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
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

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }
}
