import React, { useState, useEffect } from "react";
import User from "./User";

const Users = (props) => {
  const [user, setUser] = useState(props.user);
  const users = props.users;
  useEffect(() => {
    setUser(null);
  }, [users]);

  return (
    <>
      {user && <User user={user} />}
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
