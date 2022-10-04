import React from "react";
import { Link } from "react-router-dom";

const Header = ({ isActive }) => {
  return (
    <div id="header">
      <div>
        <Link to="/" className="logo">
          <img src="../images/logo.png" alt="" />
        </Link>
        <ul id="navigation">
          <li className={isActive === "home" ? "selected" : ""}>
            <Link to="/home">Home</Link>
          </li>
          <li className={isActive === "about" ? "menu selected" : "menu"}>
            <Link to="/about">About</Link>
            <ul
              id={isActive === "products" ? "selected" : ""}
              className="primary"
            >
              <li>
                <Link to="/products">Product</Link>
              </li>
            </ul>
          </li>
          <li className={isActive === "blog" ? "menu selected" : "menu"}>
            <Link to="/blog">Blog</Link>
            <ul
              id={isActive === "singleProduct" ? "selected" : ""}
              className="secondary"
            >
              <li>
                <Link to="/singlePost/1">Single post</Link>
              </li>
            </ul>
          </li>
          <li className={isActive === "contact" ? "selected" : ""}>
            <Link to="/contact">Contact</Link>
          </li>
        </ul>
      </div>
    </div>
  );
};

export default Header;
