import axios from "axios";
import React, { useState, useEffect } from "react";
import { BASE_URL, config } from "../api/axios";
import useAuth from "../hooks/useAuth";

const Logout = () => {
  const { auth, setAuth } = useAuth();
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    const params = {};
    const logout = async () => {
      try {
        const {
          data: { message },
        } = await axios.post(
          BASE_URL + "/userModelLogout",
          params,
          config({ token: auth.token })
        );
        console.log(message);
        setAuth({});
        localStorage.removeItem("token");
        setLoading(false);
      } catch (err) {
        console.log(err.data);
        setError(err.data);
      }
    };
    if (auth.token) logout();
  }, [auth?.token, setAuth]);

  return (
    <>
      {loading ? (
        <img src="images/loading.gif" alt="" />
      ) : (
        <section className="section">You are logged out</section>
      )}
      {error && <section className="section red">{error}</section>}
    </>
  );
};

export default Logout;
