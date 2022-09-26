import React from "react";

const User = ({ user }) => {
  const { first_name, last_name, avatar, email } = user;
  return (
    <div>
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
