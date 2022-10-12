import { NavLink } from "react-router-dom";
import { useState, useEffect } from "react";

const StyledNavbar = () => {
  const [isLogin, setIsLogin] = useState(false);
  useEffect(() => {
    if (localStorage.getItem("localeStorage")) setIsLogin(true);
  }, []);

  return (
    <nav className="navbar">
      <NavLink
        to="/home"
        className={({ isActive }) => (isActive ? "link active title" : "link")}
      >
        Home
      </NavLink>
      <NavLink
        to="/register"
        className={({ isActive }) => (isActive ? "link active title" : "link")}
      >
        Register
      </NavLink>
      <NavLink
        to="/loginDB"
        className={({ isActive }) => (isActive ? "link active title" : "link")}
      >
        Login
      </NavLink>
      {isLogin && (
        <NavLink
          to="/login"
          className={({ isActive }) =>
            isActive ? "link active title" : "link"
          }
        >
          Logout
        </NavLink>
      )}
      <NavLink
        to="/updateDeleteDB"
        className={({ isActive }) => (isActive ? "link active title" : "link")}
      >
        Update/Delete
      </NavLink>
    </nav>
  );
};
export default StyledNavbar;
