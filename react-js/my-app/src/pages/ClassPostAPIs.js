import React, { Component } from "react";
import axios from "axios";

export default class ClassPostAPIs extends Component {
  constructor() {
    super();
    this.state = { name: "", job: "", res: null };
  }
  displayError = (obj, error) => {
    obj.placeholder = error;
    obj.focus();
  };
  handleSubmit = async (e) => {
    e.preventDefault();
    if (this.state.name === "") {
      this.displayError(e.target.name, "Please enter your Name");
      return;
    }
    if (this.state.job === "") {
      this.displayError(e.target.job, "Please enter your job");
      return;
    }
    const params = { name: this.state.name, job: this.state.job };
    const url = `https://reqres.in/api/users`;

    try {
      const response = await axios.post(url, params);
      this.setState({ res: response.data });
    } catch (error) {
      console.log(error);
    }
    this.setState({ name: "" });
    this.setState({ job: "" });
  };

  render() {
    return (
      <section className="section">
        <form className="form" onSubmit={this.handleSubmit}>
          <h5>Post API </h5>
          <div className="form-row">
            <label htmlFor="name" className="form-label">
              name
            </label>
            <input
              type="text"
              className="form-input"
              id="name"
              value={this.state.name}
              onChange={(e) => this.setState({ name: e.target.value })}
            />
          </div>
          <div className="form-row">
            <label htmlFor="job" className="form-label">
              Job
            </label>
            <input
              type="text"
              className="form-input"
              id="job"
              value={this.state.job}
              onChange={(e) => this.setState({ job: e.target.value })}
            />
          </div>
          <button type="submit" className="btn btn-block">
            Post
          </button>
        </form>
        {this.state.res && (
          <div>
            Name: <strong>{this.state.res.name}</strong> Job:{" "}
            <strong>{this.state.res.job}</strong> with ID:{" "}
            <strong>{this.state.res.id}</strong> created successfully at:{" "}
            <strong>{this.state.res.createdAt}</strong>
          </div>
        )}
      </section>
    );
  }
}
