import React, { useState } from "react";
import useFetchData from "../hooks/useFetchData";
import User from "./User";

const AllUsers = () => {
  const baseURL = `https://reqres.in/api/users`;
  const [url, setUrl] = useState(baseURL);
  const [user, setUser] = useState();
  const { data } = useFetchData(url);
  const users = data.data;

  console.log(users);

  return (
    <div>
      <div>
        <select onChange={(e) => setUrl(`${baseURL}?page=${e.target.value}`)}>
          <option value="1">Page 1</option>
          <option value="2">Page 2</option>
          <option value="3">Page 3</option>
        </select>
      </div>
      <div className="container">
        {users?.length === 0 ? <h5>No Users Found!</h5> : ""}
        {user && <User user={user} />}
        {users?.map((user) => {
          const { id, first_name, avatar } = user;
          return (
            <div key={id} className="card" onClick={() => setUser(user)}>
              <div>
                <img src={avatar} alt="" />
              </div>
              <div>
                <span className="title">
                  <strong>{first_name}</strong>
                </span>
              </div>
            </div>
          );
        })}
      </div>
    </div>
  );
};

export default AllUsers;
