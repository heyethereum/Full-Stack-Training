import React from "react";
import Footer from "../components/Footer";
import Header from "../components/Header";
import { Link } from "react-router-dom";

const Home = () => {
  return (
    <div id="page">
      <Header isActive="home" />
      <div id="body" className="home">
        <div className="header">
          <img src="images/bg-home.jpg" alt="" />
          <div>
            <Link to="/products">Freeze Delight</Link>
          </div>
        </div>
        <div className="body">
          <div>
            <div>
              <h1>NEW PRODUCT</h1>
              <h2>The Twist of Healthy Yogurt</h2>
              <p>
                This website template has been designed by
                freewebsitetemplates.com for you, for free. You can replace all
                this text with your own text.
              </p>
            </div>
            <img src="images/yogurt.jpg" alt="" />
          </div>
        </div>
        <div className="footer">
          <div>
            <ul>
              <li>
                <Link to="/products" className="product"></Link>
                <h1>PRODUCTS</h1>
              </li>
              <li>
                <Link to="/products" className="about"></Link>
                <h1>OUR STORY</h1>
              </li>
              <li>
                <Link to="/products" className="flavor"></Link>
                <h1>FLAVORS</h1>
              </li>
              <li>
                <Link to="/products" className="contact"></Link>
                <h1>OUR LOCATION</h1>
              </li>
            </ul>
          </div>
        </div>
      </div>
      <Footer />
    </div>
  );
};

export default Home;
