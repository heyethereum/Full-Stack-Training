import React, { Component } from "react";

export default class ClassAge extends Component {
  constructor() {
    super();
    this.state = {
      peopleArr: [
        { name: "Piggy", age: 21 },
        { name: "Puppy", age: 41 },
        { name: "Kitty", age: 61 },
        { name: "Bunny", age: 81 },
      ],
    };
  }
  render() {
    return (
      <section className="section">
        <div className="container">
          {this.state.peopleArr.map(({ name, age }, index) => {
            return (
              <div key={index} className={age > 40 ? "red" : ""}>
                Name: {name}, Age: {age}
              </div>
            );
          })}
        </div>
      </section>
    );
  }
}
