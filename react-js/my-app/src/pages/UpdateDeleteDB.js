import React, { useState, useEffect, useCallback } from "react";
import axios from "axios";
import SingleUser from "../components/SingleUser";
import { config } from "../api/axios";
import useAuth from "../hooks/useAuth";

const UpdateDeleteDB = () => {
  const { auth } = useAuth();
  const [users, setUsers] = useState(null);
  const [selected, setSelected] = useState(null);
  const url = "http://localhost:5678/week5Assignment/userModel";

  const fetchData = useCallback(async () => {
    try {
      const { data: dbUsers } = await axios.get(
        url,
        config({ token: auth.token })
      );
      setUsers(dbUsers);
      if (!selected) setSelected(dbUsers[0].id);
    } catch (error) {
      console.log(error);
    }
  }, [selected, auth.token]);

  useEffect(() => {
    fetchData();
  }, [fetchData]);

  console.log(users);
  return (
    <section className="section">
      <div>
        <select onChange={(e) => setSelected(e.target.value)}>
          {users?.map((user) => {
            return (
              <option key={user.id} value={user.id}>
                {user.id} -- {user.name}
              </option>
            );
          })}
        </select>
      </div>
      {selected && <SingleUser selected={selected} fetchData={fetchData} />}
    </section>
  );
};

export default UpdateDeleteDB;
