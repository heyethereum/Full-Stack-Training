package java20221004;

import java.util.TreeSet;

public class SetTreeSort {
  public static void main(String[] args) {
    TreeSet<User> userList = new TreeSet<User>();
    userList.add(new User("Piggy", 41));
    userList.add(new User("Bunny", 25));
    userList.add(new User("Puppy", 23));
    userList.add(new User("Bunny", 19));

    System.out.println(userList);

    /*
     * for (User user : userList) {
     * System.out.printf("User %s is %d years old%n", user.getName(),
     * user.getAge());
     * }
     */
  }

}
