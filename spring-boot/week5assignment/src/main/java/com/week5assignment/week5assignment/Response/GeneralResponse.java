package com.week5assignment.week5assignment.Response;

public class GeneralResponse {
  private String message;

  public GeneralResponse(String message) {
    this.message = message;
  }

  public GeneralResponse() {
    super();
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
