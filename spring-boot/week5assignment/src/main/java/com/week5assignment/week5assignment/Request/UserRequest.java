package com.week5assignment.week5assignment.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequest {
  private long id;
  private String name;
  private String password;
  private String email;
  private String address;
  private String phone;

}
