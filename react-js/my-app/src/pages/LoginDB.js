import axios from "axios";
import { useState } from "react";
import { useNavigate } from "react-router-dom";

const LoginDB = ({ setUser }) => {
  const [login, setLogin] = useState({
    email: "",
    password: "",
  });
  const [error, setError] = useState("");

  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();
    const { email, password } = login;

    if (!email || !password) return;
    const url = `http://localhost:5678/week5Assignment/userModelLogin`;
    const params = login;
    try {
      const response = await axios.post(url, params);

      const { name, address, phone, token, id } = response.data;
      setUser({ name, email, address, phone });
      localStorage.setItem("token", token);
      localStorage.setItem("userid", id);
      navigate("/dashboard");
    } catch (error) {
      setError(error.response?.data?.message);
    }
  };

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
