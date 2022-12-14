package java20221004;

public class User implements Comparable<User> {
  private String name;

  private int age;
  private String address;

  public User(String name, String address) {
    this.name = name;
    this.address = address;
  }

  public User(String name, int age, String address) {
    this.name = name;
    this.age = age;
    this.address = address;
  }

  public User(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  @Override
  public int compareTo(User o) {
    return this.getName().compareTo(o.getName());
  }

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  public String toString() {
    return "User {name=" + name + ", Age=" + age + ", Address=" + address + "}";
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

}
