import React from "react";
import { Link } from "react-router-dom";

const Shop = () => {
  return (
    <div id="about" className="shop">
      <div className="container-fluid">
        <div className="row">
          <div className="col-md-5">
            <div className="shop_img">
              <figure>
                <img src="images/shop_img.png" alt="#" />
              </figure>
            </div>
          </div>
          <div className="col-md-7 padding_right0">
            <div className="max_width">
              <div className="titlepage">
                <h2>Best SunGlasses At Our shop</h2>
                <p>
                  Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
                  do eiusmod tempor incididunt ut labore et dolore magna aliqua.
                  Ut enim ad minim veniam, quis nostrud exercitation ullamco
                  laboris nisi ut aliquip ex ea commodo consequat. Duis aute
                  irure dolor in reprehenderit in voluptate velit esse cillum
                  dolore
                </p>
                <Link className="read_more" to="/">
                  Shop Now
                </Link>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Shop;
