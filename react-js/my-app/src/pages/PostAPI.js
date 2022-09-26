import React, { useState, useRef } from "react";
import axios from "axios";

const PostAPI = () => {
  const nameRef = useRef(null);
  const jobRef = useRef(null);
  const [res, setRes] = useState();

  const displayError = (obj, error) => {
    obj.current.placeholder = error;
    obj.current.focus();
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    const name = nameRef.current.value;
    const job = jobRef.current.value;

    if (name === "") {
      displayError(nameRef, "Please enter your Name");
      return;
    }
    if (job === "") {
      displayError(jobRef, "Please enter your job");
      return;
    }

    const params = { name, job };
    const url = `https://reqres.in/api/users`;

    try {
      const response = await axios.post(url, params);
      setRes(response.data);
    } catch (error) {
      console.log(error);
    }
    e.target.reset();
  };

  return (
    <section className="section">
      <form className="form" onSubmit={handleSubmit}>
        <h5>Post API </h5>
        <div className="form-row">
          <label htmlFor="name" className="form-label">
            name
          </label>
          <input type="text" className="form-input" id="name" ref={nameRef} />
        </div>
        <div className="form-row">
          <label htmlFor="job" className="form-label">
            Job
          </label>
          <input type="text" className="form-input" id="job" ref={jobRef} />
        </div>
        <button type="submit" className="btn btn-block">
          Post
        </button>
      </form>
      {res && (
        <div>
          Name: <strong>{res.name}</strong> Job: <strong>{res.job}</strong> with
          ID: <strong>{res.id}</strong> created successfully at:{" "}
          <strong>{res.createdAt}</strong>
        </div>
      )}
    </section>
  );
};

export default PostAPI;
