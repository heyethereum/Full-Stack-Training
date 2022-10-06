package java20221006;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import java20221004.User;

public class FileIOStreamWithDate {
  public static void main(String[] args) {
    ArrayList<User> userList = new ArrayList<>();
    userList.add(new User("Anna", "Orchard"));
    userList.add(new User("Bella", "Newton"));
    userList.add(new User("Chloe", "Novena"));
    userList.add(new User("Daisy", "Bugis"));
    userList.add(new User("Eleanor", "Somerset"));
    userList.add(new User("Faith", "River Valley"));
    userList.add(new User("Georgia", "Mohd Sultan"));
    userList.add(new User("Hazel", "Tiong Bahru"));
    userList.add(new User("Jill", "Tanglin"));

    // Java 7's try-with-resource statement without the need to close it in explicit
    // finally block
    try (FileOutputStream file = new FileOutputStream("java/java20221006/java20221006/output.txt", true)) {
      for (User user : userList) {
        String formattedTime = LocalDateTime.now()
            .format(DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss"));

        file.write(
            String.format("%s - Name: %s, Address: %s%n", formattedTime, user.getName(), user.getAddress())
                .getBytes());
      }
    } catch (FileNotFoundException e) {
      System.out.println("File not found!");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
