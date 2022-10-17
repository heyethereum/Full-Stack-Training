import { Navigate } from "react-router-dom";
import useAuth from "../hooks/useAuth";

const ProtectedRoute = ({ children }) => {
  const { auth } = useAuth();

  if (!auth || !Object.keys(auth).length) {
    return <Navigate to="/loginDB" />;
  }
  return children;
};
export default ProtectedRoute;
