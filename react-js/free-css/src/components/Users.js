import React from "react";

const Users = ({ users }) => {
  return (
    <>
      {users.map((user) => {
        const { id, avatar, first_name, last_name, email } = user;

        return (
          <div className="col-xl-3 col-lg-3 col-md-6 col-sm-6">
            <div className="glasses_box">
              <figure>
                <img src={avatar} alt="" />
              </figure>
              <h3>
                <span className="blu">{id} </span>
                {first_name} {last_name}
              </h3>
              <p>{email}</p>
            </div>
          </div>
        );
      })}
    </>
  );
};

export default Users;
