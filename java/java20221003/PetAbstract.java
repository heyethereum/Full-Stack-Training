
public abstract class PetAbstract {

  public static void main(String[] args) {
    System.out.println("Hello from abstract class Main method");
    Animal animal = new Animal();
    animal.greet();
    PetAbstract pet = new PetAbstract() {
      public void printName() {
        System.out.println("Printing my own name");
      }
    };
    pet.printName();
  }

  protected PetAbstract() {
    greet();
  }

  public void greet() {
    System.out.println("Hello from Abstract Pet Class greet method");
  }

  protected abstract void printName();
}
