import React, { useEffect, useReducer } from "react";
import { reducer, INITIAL_STATE } from "../utils/reducer";
import useAuth from "../hooks/useAuth";
import axios, { config } from "../api/axios";

const SingleUser = ({ selected, fetchData }) => {
  const { auth } = useAuth();
  const [state, dispatch] = useReducer(reducer, INITIAL_STATE);
  const handleFormChange = (e) => {
    setState("form", { ...state.form, [e.target.name]: e.target.value });
  };
  const setState = (key, value) => {
    dispatch({ type: "update_input", key: key, value: value });
  };
  useEffect(() => {
    const url = `/userModel/` + selected;
    const getUser = async () => {
      const { data: userData } = await axios.get(
        url,
        config({ token: auth.token })
      );
      setState("user", userData);
    };
    getUser();
    setState("msg", null);
    setState("error", null);
  }, [selected, auth?.token]);

  const handleUpdate = async (e) => {
    e.preventDefault();
    const { name, email, phone, address } = state?.form;

    let params = {};
    if (name) params = { ...params, name };
    if (email) params = { ...params, email };
    if (phone) params = { ...params, phone };
    if (address) params = { ...params, address };

    if (Object.keys(params).length === 0) return;

    try {
      const url = `/userModelUpdate`;
      params = { ...params, id: parseInt(selected) };
      console.log(params);
      const {
        data: { message },
      } = await axios.post(url, params, config({ token: auth.token }));
      setState("msg", message);
      setState("user", { ...state.user, ...params });
      fetchData();
    } catch (error) {
      setState("error", "Update Failed");
      console.log(error.response.data.message);
    }
    e.target.reset();
    dispatch({ type: "reset_form" });
  };

  const handleDelete = async (e) => {
    e.preventDefault();
    setState("msg", null);
    setState("error", null);
    try {
      const url = `/userModelDelete`;
      const params = { id: selected };
      const {
        data: { message },
      } = await axios.post(url, params, config({ token: auth.token }));
      setState("msg", message);
    } catch (error) {
      setState("error", error.response.data.message);
    }
  };

  return (
    <div>
      <form className="form" onSubmit={handleUpdate}>
        <div>
          <h5>User ID: {state.user?.id}</h5>
        </div>
        <div>
          Name:{" "}
          <input
            type="text"
            placeholder={state.user?.name}
            className="form-input"
            name="name"
            value={state.form.name}
            onChange={handleFormChange}
          ></input>
        </div>
        <div>
          Email:{" "}
          <input
            type="email"
            placeholder={state.user?.email}
            className="form-input"
            value={state.form.email}
            name="email"
            onChange={handleFormChange}
          ></input>
        </div>
        <div>
          Phone:{" "}
          <input
            type="text"
            placeholder={state.user?.phone}
            className="form-input"
            value={state.form.phone}
            name="phone"
            onChange={handleFormChange}
          ></input>
        </div>
        <div>
          Address:{" "}
          <input
            type="text"
            placeholder={state.user?.address}
            className="form-input"
            value={state.form.address}
            name="address"
            onChange={handleFormChange}
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
      {state.msg && <div>{state.msg}</div>}
      {state.error && <div className="red">{state.error}</div>}
    </div>
  );
};

export default SingleUser;
