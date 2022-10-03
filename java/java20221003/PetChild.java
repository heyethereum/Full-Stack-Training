
public class PetChild extends PetAbstract implements SuperPet, AwesomePet {
  public static void main(String[] args) {
    PetChild ps = new PetChild();
    ps.printName();
    ps.printInterface();
    ps.printInterface("implementing AwesomePet Interface");
  }

  public void printName() {
    System.out.println("printing from child of Abstract class");
  }

  @Override
  public void printInterface() {
    System.out.println("implementing SuperPet Interface");
  }

  @Override
  public void printInterface(String message) {
    System.out.println(message);
  }
}
