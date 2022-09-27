import React from "react";

export default class ClassComponent extends React.Component {
  constructor() {
    super();
    this.state = { name: "Piggy" };
    this.age = 41;
  }
  handleChange = (e) => {
    this.age = this.age - 1;
    console.log("Age:", this.age);
  };

  render() {
    return (
      <div>
        {this.state.name} {this.age}
        <input
          type="text"
          value={this.state.name}
          onChange={(e) => this.setState({ name: e.target.value })}
        />
        <input type="button" value={this.age} onClick={this.handleChange} />
      </div>
    );
  }
}
