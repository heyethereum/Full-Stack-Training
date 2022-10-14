package com.week5assignment.week5assignment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

  private long id;
  private String username;
  @JsonIgnore
  private String password;
  private String email;
  private String address;
}
