import React, { useState, useEffect } from "react";
import useFetchData from "../hooks/useFetchData";

const AllUsers = () => {
  const baseURL = `https://reqres.in/api/users`;
  const [url, setUrl] = useState(baseURL);
  const [show, setShow] = useState([]);
  const { data } = useFetchData(url);
  const users = data.data;

  const showArr = users?.map((user) => {
    return { id: user.id, show: false };
  });
  useEffect(() => {
    setShow(showArr);
  }, []);

  console.log("Hello", show);

  const setShowID = (id) => {};

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
        {users?.length === 0 ? <h5>No users found</h5> : ""}
        {users?.map((user) => {
          const { id, first_name, last_name, avatar, email } = user;
          return (
            <div key={id} className="card" onClick={() => setShow(!show)}>
              <div>
                <img src={avatar} alt="" />
              </div>
              <div>
                <span className="title">
                  <strong>{first_name}</strong>
                </span>
              </div>
              <div className={show ? "show-card-details" : "hide-card-details"}>
                <div>
                  Full Name: {first_name} {last_name}
                </div>
                <div>Email: {email}</div>
              </div>
            </div>
          );
        })}
      </div>
    </div>
  );
};

export default AllUsers;
