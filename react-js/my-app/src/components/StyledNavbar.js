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
        to="/classPostAPI"
        className={({ isActive }) => (isActive ? "link active title" : "link")}
      >
        ClassPostAPI
      </NavLink>

      <NavLink
        to="/classAge"
        className={({ isActive }) => (isActive ? "link active title" : "link")}
      >
        ClassAge
      </NavLink>
      <NavLink
        to="/classAllUsers"
        className={({ isActive }) => (isActive ? "link active title" : "link")}
      >
        ClassAllUsers
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
    </nav>
  );
};
export default StyledNavbar;
