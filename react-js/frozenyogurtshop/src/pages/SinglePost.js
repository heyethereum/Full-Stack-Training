import React from "react";
import Footer from "../components/Footer";
import Header from "../components/Header";
import { Link, useParams } from "react-router-dom";
import Sidebar from "../components/Sidebar";
import data from "../data";

const SinglePost = () => {
  const { id } = useParams();
  const post = data.find((post) => post.id === parseInt(id));

  const { largeImage, image, blogTitle, content, username, date } = post;
  const formatedDate = new Date(date);
  const month = formatedDate.toLocaleString("default", { month: "long" });
  const day = formatedDate.getDate();
  const year = formatedDate.getFullYear();

  return (
    <div id="page">
      <Header isActive="singleProduct" />
      <div id="body">
        <div className="header">
          <div>
            <h1>Single Post</h1>
          </div>
        </div>
        <div className="singlepost">
          <div className="featured">
            <img src={largeImage || image} alt="" />
            <h1>{blogTitle}</h1>
            <span>
              By {username} on {month} {day}, {year}
            </span>
            <p>{content}</p>
            <p>{content}</p>
            <Link to="/blog" className="load">
              back to blog
            </Link>
          </div>
          <Sidebar />
        </div>
      </div>
      <Footer />
    </div>
  );
};

export default SinglePost;
