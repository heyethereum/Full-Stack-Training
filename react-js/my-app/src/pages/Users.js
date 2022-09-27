import React from "react";

const Users = ({ users, setUser }) => {
  return (
    <>
      {users.map((user) => {
        const { id, first_name, avatar } = user;
        return (
          <div key={id} className="card" onClick={() => setUser(user)}>
            <div>
              <img src={avatar} alt="" />
            </div>
            <div className="title">{first_name}</div>
          </div>
        );
      })}
    </>
  );
};

export default Users;
