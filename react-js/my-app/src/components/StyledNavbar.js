import { NavLink } from "react-router-dom";
import useAuth from "../hooks/useAuth";

const StyledNavbar = () => {
  const { auth } = useAuth();

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
      <NavLink
        to="/updateDeleteDB"
        className={({ isActive }) => (isActive ? "link active title" : "link")}
      >
        Update/Delete
      </NavLink>
      {auth?.token && (
        <NavLink
          to="/logout"
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
