public class CustomExcption extends Exception {
  CustomExcption(String message) {
    super(message);
    System.out.println(message);
  }

  CustomExcption(String message, int errorCode) {
    super(message);
    System.out.printf("Error %d %s%n", errorCode, message);
  }
}
