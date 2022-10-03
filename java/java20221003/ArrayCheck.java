
/* throw->to return the error
throws->declaring the method as it may return the error
throwable->parent class for all the exception.
 */

public class ArrayCheck {
  public static void main(String[] args) {
    System.out.println("Start of program");
    ArrayCheck arrayCheck = new ArrayCheck();
    int index = 2;
    int index2 = 7;
    try {
      System.out.printf("Array at index %d is %d%n", index, arrayCheck.getIndexValue(index));
      System.out.printf("Array at index %d is %d%n", index, arrayCheck.getIndexValue(index2));
    } catch (CustomExcption e) {
      System.out.println(e.getMessage());
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("End of program");
  }

  public int getIndexValue(int index) throws CustomExcption {
    int[] numberArray = { 1, 2, 3, 4, 5, 6 };
    if (index > numberArray.length - 1) {
      throw new CustomExcption("Custom Exception: Array out of bound.", 110);
    } else {
      return numberArray[index];

    }
  }
}
