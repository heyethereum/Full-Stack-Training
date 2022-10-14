import React, { useState, useEffect } from "react";
import axios from "axios";

const SingleUser = ({ selected, fetchData }) => {
  const [user, setUser] = useState(null);
  const [msg, setMsg] = useState(null);
  const [error, setError] = useState(null);
  const [formData, setFormData] = useState({
    name: "",
    email: "",
    password: "",
    phone: "",
    address: "",
  });

  useEffect(() => {
    const config = {
      headers: {
        "Content-Type": "application/json",
        userid: localStorage.getItem("userid"),
        token: localStorage.getItem("token"),
      },
    };
    const url = `http://localhost:5678/week5Assignment/userModel/` + selected;
    const getUser = async () => {
      const { data: userData } = await axios.get(url, config);
      setUser(userData);
    };
    getUser();
    setMsg(null);
    setError(null);
  }, [selected]);

  const handleUpdate = async (e) => {
    e.preventDefault();
    const { name, email, phone, address } = formData;

    let params = {};
    if (name) params = { ...params, name };
    if (email) params = { ...params, email };
    if (phone) params = { ...params, phone };
    if (address) params = { ...params, address };

    if (Object.keys(params).length === 0) return;

    try {
      const url = `http://localhost:5678/week5Assignment/userModelUpdate`;
      params = { ...params, id: parseInt(selected) };
      console.log(params);
      const {
        data: { message },
      } = await axios.post(url, params);
      setMsg(message);
      setUser((prevState) => {
        return { ...prevState, ...params };
      });
      fetchData();
    } catch (error) {
      setError(error.response.data.message);
      console.log(error.response.data.message);
    }
    e.target.reset();
    setFormData({
      name: "",
      email: "",
      password: "",
      phone: "",
      address: "",
    });
  };

  const handleDelete = async (e) => {
    e.preventDefault();
    setMsg(null);
    setError(null);
    try {
      const url = `http://localhost:5678/week5Assignment/userModelDelete`;
      const params = { id: selected };
      const {
        data: { message },
      } = await axios.post(url, params);
      setMsg(message);
    } catch (error) {
      setError(error.response.data.message);
      console.log(error.response.data.message);
    }
  };

  return (
    <div>
      <form className="form" onSubmit={handleUpdate}>
        <div>
          <h5>User ID: {user?.id}</h5>
        </div>
        <div>
          Name:{" "}
          <input
            type="text"
            placeholder={user?.name}
            className="form-input"
            onChange={(e) =>
              setFormData((prevState) => {
                return { ...prevState, name: e.target.value };
              })
            }
          ></input>
        </div>
        <div>
          Email:{" "}
          <input
            type="email"
            placeholder={user?.email}
            className="form-input"
            onChange={(e) =>
              setFormData((prevState) => {
                return { ...prevState, email: e.target.value };
              })
            }
          ></input>
        </div>
        <div>
          Phone:{" "}
          <input
            type="text"
            placeholder={user?.phone}
            className="form-input"
            onChange={(e) =>
              setFormData((prevState) => {
                return { ...prevState, phone: e.target.value };
              })
            }
          ></input>
        </div>
        <div>
          Address:{" "}
          <input
            type="text"
            placeholder={user?.address}
            className="form-input"
            onChange={(e) =>
              setFormData((prevState) => {
                return { ...prevState, address: e.target.value };
              })
            }
          ></input>
        </div>
        <div>
          <button className="btn-block btn" type="submit">
            Update
          </button>
          <button className="btn-block btn" onClick={handleDelete}>
            Delete
          </button>
        </div>
      </form>
      {msg && <div>{msg}</div>}
      {error && <div className="red">{error}</div>}
    </div>
  );
};

export default SingleUser;
