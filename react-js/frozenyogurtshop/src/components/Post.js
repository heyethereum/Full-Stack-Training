import React from "react";
import { Link } from "react-router-dom";

const Post = ({ post }) => {
  const { id, image, blogTitle, content, date, username } = post;
  const formatedDate = new Date(date);
  const month = formatedDate.toLocaleString("default", { month: "long" });
  const day = formatedDate.getDate();
  const year = formatedDate.getFullYear();
  return (
    <li>
      <img src={image} alt="" />
      <div>
        <h1>{blogTitle}</h1>
        <span>
          By {username} on {month} {day}, {year}
        </span>
        <p>{content}</p>
        <Link to={`/singlePost/${id}`} className="more">
          Read More
        </Link>
      </div>
    </li>
  );
};

export default Post;
