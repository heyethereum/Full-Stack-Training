import React from "react";

const User = ({ user }) => {
  const { first_name, last_name, avatar, email } = user;
  return (
    <div style={{ margin: "30px 0 30px 20px" }}>
      <div>
        <img src={avatar} alt="" />
      </div>
      <div>
        Name: {first_name} {last_name}
      </div>
      <div>Email: {email}</div>
    </div>
  );
};

export default User;
