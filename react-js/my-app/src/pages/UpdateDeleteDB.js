import React, { useState, useEffect, useCallback } from "react";
import SingleUser from "../components/SingleUser";
import { config } from "../api/axios";
import useAuth from "../hooks/useAuth";
import useAxiosPrivate from "../hooks/useAxiosPrivate";

const UpdateDeleteDB = () => {
  const { auth } = useAuth();
  const axiosPrivate = useAxiosPrivate();
  const [users, setUsers] = useState(null);
  const [selected, setSelected] = useState(null);

  const fetchData = useCallback(async () => {
    try {
      const { data: dbUsers } = await axiosPrivate.get(
        `/userModel`,
        config({ token: auth.token })
      );
      setUsers(dbUsers);
      if (!selected) setSelected(dbUsers[0].id);
    } catch (error) {
      console.log("Error in fetching:", error);
    }
  }, [selected, auth?.token, axiosPrivate]);

  useEffect(() => {
    fetchData();
    console.log("Access Token:", auth?.token);
  }, [fetchData, auth?.token]);

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
