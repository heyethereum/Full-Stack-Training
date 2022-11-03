import axios from "axios";

export const BASE_URL = "http://localhost:5678/week5Assignment";
export const config = ({ token }) => {
  return {
    headers: {
      "Content-Type": "application/json",
      token: token,
    },
  };
};
export const headers = ({ token }) => {
  return {
    "Content-Type": "application/json",
    token: token,
  };
};

export default axios.create({
  baseURL: BASE_URL,
  withCredentials: true,
});

export const axiosPrivate = axios.create({
  baseURL: BASE_URL,
  headers: { "Content-Type": "application/json" },
  withCredentials: true,
});
