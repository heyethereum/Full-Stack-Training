import React, { useState } from "react";
import axios from "axios";

const PostAPI = () => {
  const [name, setName] = useState("");
  const [job, setJob] = useState("");
  const [res, setRes] = useState();

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (name === "" || job === "") return;

    const params = { name, job };
    const url = `https://reqres.in/api/users`;

    try {
      const response = await axios.post(url, params);
      setRes(response.data);
    } catch (error) {
      console.log(error);
    }
  };

  return (
    <section className="section">
      <form className="form" onSubmit={handleSubmit}>
        <h5>Post API </h5>
        <div className="form-row">
          <label htmlFor="name" className="form-label">
            name
          </label>
          <input
            type="text"
            className="form-input"
            id="name"
            onChange={(e) => setName(e.target.value)}
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
            onChange={(e) => setJob(e.target.value)}
          />
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
