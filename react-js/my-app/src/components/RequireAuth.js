import { useLocation, Navigate, Outlet } from "react-router-dom";
import useAuth from "../hooks/useAuth";

const RequireAuth = () => {
  const { auth } = useAuth();
  const location = useLocation();
  console.log("Require Auth: ", auth);
  return auth?.token && auth?.token !== "undefined" ? (
    <Outlet />
  ) : (
    <Navigate to="/loginDB" state={{ from: location }} replace />
  );
};

export default RequireAuth;
