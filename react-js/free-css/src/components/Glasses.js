import React from "react";
import { Link } from "react-router-dom";
import useFetchData from "../hooks/useFetchData";
import Users from "./Users";

const Glasses = () => {
  const {
    data: { data: users },
  } = useFetchData("https://reqres.in/api/users");
  console.log(users);
  return (
    <div className="glasses">
      <div className="container">
        <div className="row">
          <div className="col-md-10 offset-md-1">
            <div className="titlepage">
              <h2>Our Glasses</h2>
              <p>
                Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do
                eiusmod tempor incididunt ut labor e et dolore magna aliqua. Ut
                enim ad minim veniam, qui
              </p>
            </div>
          </div>
        </div>
      </div>
      <div className="container-fluid">
        <div className="row">
          {users && <Users users={users} />}
          <div className="col-md-12">
            <Link className="read_more" to="/">
              Read More
            </Link>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Glasses;
