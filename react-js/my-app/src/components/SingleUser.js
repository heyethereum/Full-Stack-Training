import React, { useState, useEffect, useMemo, useReducer } from "react";
import axios from "axios";

export const INITIALSTATE = {
  form: { name: "", email: "", password: "", phone: "", address: "" },
};
const reducer = (state, action) => {
  console.log("action: ", action);
  switch (action.type) {
    case "update_input":
      return {
        ...state,
        [action.payload.key]: action.payload.value,
      };
    case "reset_state":
      return INITIALSTATE;
    default:
      return state;
  }
};

const SingleUser = ({ selected, fetchData }) => {
  const [user, setUser] = useState(null);
  const [msg, setMsg] = useState(null);
  const [error, setError] = useState(null);
  const [state, dispatch] = useReducer(reducer, INITIALSTATE);
  const config = useMemo(
    () => ({
      headers: {
        "Content-Type": "application/json",
        userid: localStorage.getItem("userid"),
        token: localStorage.getItem("token"),
      },
    }),
    []
  );
  const handleChange = (e) => {
    dispatch({
      type: "update_input",
      payload: { key: "form", value: { [e.target.name]: e.target.value } },
    });
  };

  useEffect(() => {
    const url = `http://localhost:5678/week5Assignment/userModel/` + selected;
    const getUser = async () => {
      const { data: userData } = await axios.get(url, config);
      setUser(userData);
    };
    getUser();
    setMsg(null);
    setError(null);
  }, [selected, config]);

  const handleUpdate = async (e) => {
    e.preventDefault();
    const { name, email, phone, address } = state.form;
    console.log("state: ", state);
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
      } = await axios.post(url, params, config);
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
    dispatch({ type: "reset_state" });
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
      } = await axios.post(url, params, config);
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
            name="name"
            value={state.form.name}
            onChange={handleChange}
          ></input>
        </div>
        <div>
          Email:{" "}
          <input
            type="email"
            placeholder={user?.email}
            className="form-input"
            value={state.form.email}
            name="email"
            onChange={handleChange}
          ></input>
        </div>
        <div>
          Phone:{" "}
          <input
            type="text"
            placeholder={user?.phone}
            className="form-input"
            value={state.form.phone}
            name="phone"
            onChange={handleChange}
          ></input>
        </div>
        <div>
          Address:{" "}
          <input
            type="text"
            placeholder={user?.address}
            className="form-input"
            value={state.form.address}
            name="address"
            onChange={handleChange}
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
