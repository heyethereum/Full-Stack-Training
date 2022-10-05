package java20221005;

import java.util.ArrayList;
import java.util.HashMap;

import java20221004.User;

public class HashmapArrayList {
  public static void main(String[] args) {
    ArrayList<User> centralList = new ArrayList<>();
    centralList.add(new User("Alice", 18, "Orchard"));
    centralList.add(new User("Anna", 20, "Newton"));
    centralList.add(new User("Amy", 35, "Novena"));
    ArrayList<User> eastList = new ArrayList<>();
    eastList.add(new User("Belle", 19, "Tampines"));
    eastList.add(new User("Brenda", 23, "Bedok"));
    eastList.add(new User("Baby", 45, "East Coast"));
    ArrayList<User> westList = new ArrayList<>();
    westList.add(new User("Clara", 23, "Jurong"));
    westList.add(new User("Caroline", 25, "Clementi"));
    westList.add(new User("Cecillia", 41, "West Coast"));

    HashMap<String, ArrayList<User>> hashMap = new HashMap<>();
    hashMap.put("Central", centralList);
    hashMap.put("East", eastList);
    hashMap.put("West", westList);

    System.out.println(hashMap.get("Central").get(1).getName()); // Anna

    hashMap.forEach((key, userList) -> {
      System.out.printf("People living in %s:%n", key);
      userList.forEach(System.out::println);
    });
  }
}
