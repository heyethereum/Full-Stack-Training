public class StringLong {
  String[] pets = { "piggy", "puppy", "kitty", "bunny" };
  long[] longNums = { 111111, 222222222, 1333333333333l };

  public static void main(String[] args) {
    StringLong stringLong = new StringLong();
    for (String pet : stringLong.pets) {
      System.out.printf("String array: %s.%n", pet);
    }
    for (long num : stringLong.longNums) {
      System.out.printf("Long array: %d.%n", num);
    }
  }
}