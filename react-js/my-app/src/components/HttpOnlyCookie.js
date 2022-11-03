import React from "react";
import { useLocation, useNavigate } from "react-router-dom";
import useAuth from "../hooks/useAuth";
import useRefreshToken from "../hooks/useRefreshToken";

const HttpOnlyCookie = () => {
  const { auth, setAuth } = useAuth();
  const refresh = useRefreshToken();
  const location = useLocation();
  const navigate = useNavigate();

  const handleclick = async (e) => {
    e.preventDefault();
    try {
      refresh();
    } catch (error) {
      navigate("/loginDB", { state: { from: location }, replace: true });
      setAuth({});
    }
  };

  return (
    <div>
      HttpOnlyCookie {auth?.token}
      <button onClick={handleclick}> Refresh TOken</button>
    </div>
  );
};

export default HttpOnlyCookie;
