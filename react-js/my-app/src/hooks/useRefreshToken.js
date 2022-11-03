import { useLocation, useNavigate } from "react-router-dom";
import axios from "../api/axios";
import useAuth from "./useAuth";

const useRefreshToken = () => {
  const { setAuth } = useAuth();
  const location = useLocation();
  const from = location.state?.from?.pathname || "/";
  const navigate = useNavigate();

  const refresh = async () => {
    try {
      const response = await axios.get("/refreshtoken");
      const userDetails = response?.data || {};
      console.log("useRefreshToken userDetails:", userDetails);
      setAuth((prev) => {
        return { ...prev, ...userDetails };
      });
      return response.data?.token;
    } catch (error) {
      console.log("useRefreshToken catch error:", error.data);
      navigate("/loginDB", { state: { from: from }, replace: true });
      setAuth({});
    }
  };
  return refresh;
};

export default useRefreshToken;
