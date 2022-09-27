import React, { useState } from "react";
import useFetchData from "../hooks/useFetchData";
import Users from "./Users";

const AllUsers = () => {
  const baseURL = `https://reqres.in/api/users`;
  const [url, setUrl] = useState(baseURL);
  const { data } = useFetchData(url);
  const users = data.data;

  const handleChange = (e) => {
    setUrl(`${baseURL}?page=${e.target.value}`);
  };

  return (
    <section className="section">
      <div>
        <select onChange={handleChange}>
          <option value="1">Page 1</option>
          <option value="2">Page 2</option>
          <option value="3">Page 3</option>
        </select>
      </div>
      <div className="container-flex">
        {users?.length === 0 ? (
          <h5 style={{ marginTop: "20px" }}>No Users Found!</h5>
        ) : (
          ""
        )}
        {users && <Users users={users} />}
      </div>
    </section>
  );
};

export default AllUsers;
