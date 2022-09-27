import React, { Component } from "react";
import Users from "./Users";
import axios from "axios";

export default class ClassAllUsers extends Component {
  constructor() {
    super();
    this.baseURL = `https://reqres.in/api/users?page=`;
    this.state = { users: null };
  }
  componentDidMount() {
    this.getAPIResponse(1);
  }
  getAPIResponse = async (page) => {
    try {
      const { data: response } = await axios.get(this.baseURL + page);
      this.setState({ users: response.data });
    } catch (error) {
      console.log(error);
    }
  };
  handleChange = (e) => {
    this.getAPIResponse(e.target.value);
  };
  render() {
    return (
      <section className="section">
        <div>
          <select onChange={this.handleChange}>
            <option value="1">Page 1</option>
            <option value="2">Page 2</option>
            <option value="3">Page 3</option>
          </select>
        </div>
        <div className="container-flex">
          {this.state.users && <Users users={this.state.users} />}
        </div>
      </section>
    );
  }
}
