import React, { useState, useEffect } from "react";
import axios from "axios";
import SingleUser from "../components/SingleUser";

const UpdateDeleteDB = () => {
  const [users, setUsers] = useState(null);
  const [selected, setSelected] = useState(null);
  const url = "http://localhost:5678/week5Assignment/userModel";

  useEffect(() => {
    const fetchData = async () => {
      try {
        const { data: dbUsers } = await axios.get(url);
        setUsers(dbUsers);
      } catch (error) {
        console.log(error);
      }
    };
    fetchData();
  }, [selected]);

  console.log(users);
  return (
    <section className="section">
      <div>
        <select onChange={(e) => setSelected(e.target.value)}>
          <option>Select User ID</option>
          {users?.map((user) => {
            return (
              <option key={user.id} value={user.id}>
                {user.id}
              </option>
            );
          })}
        </select>
      </div>
      {selected && <SingleUser selected={selected} />}
    </section>
  );
};

export default UpdateDeleteDB;
