import React from "react";
import Footer from "../components/Footer";
import Header from "../components/Header";
import { Link } from "react-router-dom";
import Sidebar from "../components/Sidebar";

const SinglePost = () => {
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
            <img src="images/strwberry-delights.jpg" alt="" />
            <h1>NEW CHILLS FOR SUMMER</h1>
            <span>By Admin on November 28, 2023</span>
            <p>
              You can replace all this text with your own text. You can remove
              any link to our website from this website template, you're free to
              use this website template without linking back to us. If you're
              having problems editing this website template, then don't hesitate
              to ask for help on the forum.
            </p>
            <p>
              You can replace all this text with your own text. You can remove
              any link to our website from this website template, you're free to
              use this website template without linking back to us. If you're
              having problems editing this website template, then don't hesitate
              to ask for help on the forum.
            </p>
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
