package java20221005;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import java20221004.User;

public class FilteringArrayList {
  public static void main(String[] args) {
    ArrayList<User> userList = new ArrayList<>();
    userList.add(new User("Piggy", 17));
    userList.add(new User("Bunny", 18));
    userList.add(new User("Puppy", 25));
    userList.add(new User("Kitty", 30));
    userList.add(new User("Anastasia", 19));
    userList.add(new User("Aladdin", 40));

    userList.stream().filter(user -> user.getAge() < 20).forEach(System.out::println);
    List<User> userNameStartwithA = userList.stream().filter(user -> user.getName().toLowerCase().startsWith("a"))
        .limit(1)
        .collect(Collectors.toList());
    System.out.println(userNameStartwithA);
  }
}
