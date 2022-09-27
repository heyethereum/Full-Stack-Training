import React, { useState, useEffect } from "react";
import User from "./User";

const Users = ({ users }) => {
  const [user, setUser] = useState(null);

  useEffect(() => {
    setUser(null);
  }, [users]);

  return (
    <>
      {users?.length === 0 ? (
        <h5 style={{ marginTop: "20px" }}>No Users Found!</h5>
      ) : (
        ""
      )}
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
