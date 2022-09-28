import React from "react";
import { Link } from "react-router-dom";
import Footer from "../components/Footer";
import Header from "../components/Header";
import AboutComponent from "../components/About";
import ContactComponent from "../components/Contact";
import GlassesComponent from "../components/Glasses";
import ShopComponent from "../components/Shop";
import ClientsComponent from "../components/Clients";

const Home = () => {
  return (
    <div className="main-layout">
      <Header />
      <section className="banner_main">
        <div id="banner1" className="carousel slide" data-ride="carousel">
          <ol className="carousel-indicators">
            <li
              data-target="#banner1"
              data-slide-to="0"
              className="active"
            ></li>
            <li data-target="#banner1" data-slide-to="1"></li>
            <li data-target="#banner1" data-slide-to="2"></li>
          </ol>
          <div className="carousel-inner">
            <div className="carousel-item active">
              <div className="container">
                <div className="carousel-caption">
                  <div className="text-bg">
                    <h1>
                      {" "}
                      <span className="blu">
                        Welcome <br />
                      </span>
                      To Our Sunglasses
                    </h1>
                    <figure>
                      <img src="images/banner_img.png" alt="#" />
                    </figure>
                    <Link className="read_more" to="/">
                      Shop Now
                    </Link>
                  </div>
                </div>
              </div>
            </div>
            <div className="carousel-item">
              <div className="container">
                <div className="carousel-caption">
                  <div className="text-bg">
                    <h1>
                      {" "}
                      <span className="blu">
                        Welcome <br />
                      </span>
                      To Our Sunglasses
                    </h1>
                    <figure>
                      <img src="images/banner_img.png" alt="#" />
                    </figure>
                    <Link className="read_more" to="/">
                      Shop Now
                    </Link>
                  </div>
                </div>
              </div>
            </div>
            <div className="carousel-item">
              <div className="container">
                <div className="carousel-caption">
                  <div className="text-bg">
                    <h1>
                      {" "}
                      <span className="blu">
                        Welcome <br />
                      </span>
                      To Our Sunglasses
                    </h1>
                    <figure>
                      <img src="images/banner_img.png" alt="#" />
                    </figure>
                    <Link className="read_more" to="/">
                      Shop Now
                    </Link>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <a
            className="carousel-control-prev"
            href="#banner1"
            role="button"
            data-slide="prev"
          >
            <i className="fa fa-arrow-left" aria-hidden="true"></i>
          </a>
          <a
            className="carousel-control-next"
            href="#banner1"
            role="button"
            data-slide="next"
          >
            <i className="fa fa-arrow-right" aria-hidden="true"></i>
          </a>
        </div>
      </section>
      <AboutComponent />
      <GlassesComponent />
      <ShopComponent />
      <ClientsComponent />
      <ContactComponent />
      <Footer />
    </div>
  );
};

export default Home;
