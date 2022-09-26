import React from "react";
import useFetchData from "../hooks/useFetchData";

const AllUsers = () => {
  const url = `https://reqres.in/api/users`;
  const { data } = useFetchData(url);
  const users = data.data;
  console.log(users);
  return (
    <div>
      {users?.map((user) => {
        const { id, first_name, avatar } = user;
        return (
          <div key={id}>
            <img src={avatar} alt="" />
            {first_name}
          </div>
        );
      })}
    </div>
  );
};

export default AllUsers;
