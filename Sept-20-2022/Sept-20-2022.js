import Person3 from "./Person2.js";
class Person {
  constructor(name) {
    this.name = name;
  }

  print() {
    console.log("Hello");
  }
}

//Person.print();

let person = new Person("piggy");
person.print();

let person2 = new Person3();
