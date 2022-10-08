package com.week5assignment.week5assignment.services;

import java.text.DecimalFormat;

import org.springframework.stereotype.Service;

@Service
public class MathServiceImpl implements MathService {

  @Override
  public String calculate(int num1, int num2, String operation) {
    String result = "Result is ";
    switch (operation.toLowerCase()) {
      case "add":
        return result + (num1 + num2);
      case "subtract":
        return result + (num1 - num2);
      case "multiply":
        return result + (num1 * num2);
      case "divide":
        return result + new DecimalFormat("###.###").format((double) num1 / num2);
      default:
        return "Invalid Operation!";
    }
  }

}
