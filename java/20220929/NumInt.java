public class NumInt {
  int[] num = { -10, 0, 100, 2, 30, 40, 50 };

  public static void main(String[] args) {
    NumInt numInt = new NumInt();
    for (int num : numInt.num) {
      if (num > 10)
        System.out.printf("Number %d is greater than 10.%n", num);
      else
        System.out.printf("Number %d is lesser than 10.%n", num);
    }
  }
}
