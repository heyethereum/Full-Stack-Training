package java20221004;

import java.util.TreeSet;

public class SetTreeSort {
  public static void main(String[] args) {
    TreeSet<User> userList = new TreeSet<User>();
    User user1 = new User("Piggy", 21);
    User user2 = new User("Bunny", 18);
    User user3 = new User("Puppy", 23);
    User user4 = new User("Bunny", 19);
    userList.add(user1);
    userList.add(user2);
    userList.add(user3);
    userList.add(user4);

    for (User user : userList) {
      System.out.printf("%s is %d years old%n", user.getName(), user.getAge());
    }
  }

}
