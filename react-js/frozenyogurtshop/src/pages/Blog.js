import React from "react";
import Footer from "../components/Footer";
import Header from "../components/Header";
import { Link } from "react-router-dom";
import Post from "../components/Post";
import data from "../data";
import Sidebar from "../components/Sidebar";

const Blog = () => {
  return (
    <div id="page">
      <Header isActive="blog" />
      <div id="body">
        <div className="header">
          <div>
            <h1>Blog</h1>
          </div>
        </div>
        <div className="blog">
          <div className="featured">
            <ul>
              {data
                .filter((post) => post.id <= 2)
                .map((post) => {
                  console.log(post);
                  return <Post post={post} />;
                })}
            </ul>
            <Link to="/blog" className="load">
              Load More
            </Link>
          </div>
          <Sidebar />
        </div>
      </div>
      <Footer />
    </div>
  );
};

export default Blog;
