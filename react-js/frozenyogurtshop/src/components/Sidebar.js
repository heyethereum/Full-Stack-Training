import React from "react";
import data from "../data";
import { Link } from "react-router-dom";

const Sidebar = () => {
  const featured = data.find((post) => post.id === 3);
  return (
    <div className="sidebar">
      <h1>Recent Posts</h1>
      <img src={featured?.image} alt="" />
      <h2>{featured?.blogTitle}</h2>
      <span>
        By {featured?.username} on {featured?.date}
      </span>
      <p>{featured?.content}</p>
      <Link to={`/singlePost/${featured?.id}`} className="more">
        Read More
      </Link>
    </div>
  );
};

export default Sidebar;
