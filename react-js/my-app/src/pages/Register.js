import { useState } from "react";
import axios from "axios";

const Register = () => {
  const [user, setUser] = useState({
    name: "",
    email: "",
    password: "",
    phone: "",
    address: "",
  });
  const [message, setMessage] = useState("");
  const [error, setError] = useState("");

  console.log(user);

  const handleSubmit = async (e) => {
    e.preventDefault();
    setMessage("");
    setError("");

    const { name, password, email, phone, address } = user;
    if (!name || !email || !password || !phone || !address) return;

    const url = `http://localhost:5678/week5Assignment/userModelRegister`;
    const params = user;
    try {
      const response = await axios.post(url, params);
      setMessage(response?.data?.message);
    } catch (error) {
      setError(error.response?.data?.message);
    }
  };
  return (
    <section className="section">
      <form className="form" onSubmit={handleSubmit}>
        <h5>Registration Form</h5>
        <div className="form-row">
          <label htmlFor="name" className="form-label">
            name
          </label>
          <input
            type="text"
            className="form-input"
            id="name"
            onChange={(e) =>
              setUser((prevState) => {
                return { ...prevState, name: e.target.value };
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
              setUser((prevState) => {
                return { ...prevState, password: e.target.value };
              })
            }
          />
        </div>
        <div className="form-row">
          <label htmlFor="email" className="form-label">
            email
          </label>
          <input
            type="email"
            className="form-input"
            id="email"
            onChange={(e) =>
              setUser((prevState) => {
                return { ...prevState, email: e.target.value };
              })
            }
          />
        </div>
        <div className="form-row">
          <label htmlFor="phone" className="form-label">
            phone
          </label>
          <input
            type="text"
            className="form-input"
            id="phone"
            onChange={(e) =>
              setUser((prevState) => {
                return { ...prevState, phone: e.target.value };
              })
            }
          />
        </div>
        <div className="form-row">
          <label htmlFor="address" className="form-label">
            address
          </label>
          <input
            type="text"
            className="form-input"
            id="address"
            onChange={(e) =>
              setUser((prevState) => {
                return { ...prevState, address: e.target.value };
              })
            }
          />
        </div>
        <button type="submit" className="btn btn-block">
          Register
        </button>
      </form>
      {message && <div>{message}</div>}
      {error && <div className="red">{error}</div>}
    </section>
  );
};

export default Register;
