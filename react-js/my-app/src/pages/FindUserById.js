import React, { useRef, useState } from "react";
import axios from "axios";

const FindUserById = () => {
  const idRef = useRef(null);
  const [res, setRes] = useState();
  const [error, setError] = useState(null);

  const displayError = (obj, error) => {
    obj.current.placeholder = error;
    obj.current.focus();
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setError(null);
    setRes(null);
    const id = idRef.current.value;

    if (id === "") {
      displayError(idRef, "Please enter userId");
      return;
    }
    const url = `http://localhost:5678/week5Assignment/user/` + id;

    try {
      const response = await axios.get(url);
      console.log(response);
      setRes(response.data);
    } catch (error) {
      console.log(error.response.data);
      setError(error.response.data);
    }
    e.target.reset();
  };
  return (
    <section className="section">
      <form className="form" onSubmit={handleSubmit}>
        <h5>Get User by Id</h5>
        <div className="form-row">
          <label htmlFor="id" className="form-label">
            id
          </label>
          <input type="text" className="form-input" id="id" ref={idRef} />
        </div>
        <button type="submit" className="btn btn-block">
          Post
        </button>
      </form>
      {res && (
        <div>
          <div>ID: {res.id}</div>
          <div>Username: {res.username}</div>
          <div>Email: {res.email}</div>
          <div>Address: {res.address}</div>
        </div>
      )}
      {error && (
        <div>
          <strong>Error: {error.message}</strong>
        </div>
      )}
    </section>
  );
};

export default FindUserById;
