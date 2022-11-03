import { useState, useEffect, useRef } from "react";
import { useNavigate, useLocation } from "react-router-dom";
import axios from "../api/axios";
import useAuth from "../hooks/useAuth";

const LoginDB = () => {
  const { setAuth } = useAuth();
  const [login, setLogin] = useState({
    email: "",
    password: "",
  });
  const location = useLocation();
  const from = location.state?.from?.pathname || "/";

  const emailRef = useRef(null);
  const [error, setError] = useState(null);

  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();
    const { email, password } = login;

    if (!email || !password) return;
    const url = `/userModelLogin`;
    const params = login;
    try {
      const response = await axios.post(url, params);

      const { name, address, phone, token } = response?.data;
      setAuth({ name, email, address, phone, token });
      navigate(from, { replace: true });
    } catch (error) {
      setError(error.response?.data?.message);
    }
  };
  useEffect(() => {
    emailRef.current.focus();
  }, []);

  useEffect(() => {
    setError(null);
  }, [login]);

  return (
    <section className="section">
      <form className="form" onSubmit={handleSubmit}>
        <h5>login</h5>
        <div className="form-row">
          <label htmlFor="email" className="form-label">
            email
          </label>
          <input
            type="text"
            className="form-input"
            id="email"
            ref={emailRef}
            onChange={(e) =>
              setLogin((prevState) => {
                return { ...prevState, email: e.target.value };
              })
            }
          />
        </div>
        <div className="form-row">
          <label htmlFor="password" className="form-label">
            password
          </label>
          <input
            type="password"
            className="form-input"
            id="password"
            onChange={(e) =>
              setLogin((prevState) => {
                return { ...prevState, password: e.target.value };
              })
            }
          />
        </div>
        <button type="submit" className="btn btn-block">
          login
        </button>
      </form>
      {error && <div className="red">{error}</div>}
    </section>
  );
};

export default LoginDB;
