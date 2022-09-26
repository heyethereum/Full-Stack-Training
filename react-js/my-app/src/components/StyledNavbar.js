import { NavLink } from "react-router-dom";
const StyledNavbar = () => {
  return (
    <nav className="navbar">
      <NavLink
        to="/home"
        className={({ isActive }) => (isActive ? "link active title" : "link")}
      >
        Home
      </NavLink>
      <NavLink
        to="/postApi"
        className={({ isActive }) => (isActive ? "link active title" : "link")}
      >
        PostAPI
      </NavLink>

      <NavLink
        to="/age"
        className={({ isActive }) => (isActive ? "link active title" : "link")}
      >
        Age
      </NavLink>
      <NavLink
        to="/users"
        className={({ isActive }) => (isActive ? "link active title" : "link")}
      >
        Users
      </NavLink>
    </nav>
  );
};
export default StyledNavbar;
