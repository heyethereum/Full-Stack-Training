import React, { useRef } from "react";

const Contact = () => {
  let inputRefs = useRef({
    name: React.createRef(),
    phone: React.createRef(),
    email: React.createRef(),
    msg: React.createRef(),
  });

  const validate = (obj) => {
    if (!obj.value) {
      obj.className = "contactus-error";
      obj.focus();
    } else {
      obj.className = "contactus";
    }
  };
  // looping through input to validate empty string
  const handleSubmit = (e) => {
    e.preventDefault();
    // reverse order to focus on first input
    for (const key of Object.keys(inputRefs.current).reverse()) {
      validate(inputRefs.current[key].current);
    }
  };

  return (
    <div id="contact" className="contact">
      <div className="container">
        <div className="row">
          <div className="col-md-6">
            <form id="request" className="main_form" onSubmit={handleSubmit}>
              <div className="row">
                <div className="col-md-12 ">
                  <h3>Contact Us</h3>
                </div>
                <div className="col-md-12 ">
                  <input
                    className="contactus"
                    placeholder="Name"
                    ref={inputRefs.current["name"]}
                    type="text"
                    name="Name"
                    onChange={(e) => validate(e.target)}
                  />
                </div>
                <div className="col-md-12">
                  <input
                    className="contactus"
                    placeholder="Phone Number"
                    ref={inputRefs.current["phone"]}
                    type="text"
                    name="Phone Number"
                    onChange={(e) => validate(e.target)}
                  />
                </div>
                <div className="col-md-12">
                  <input
                    className="contactus"
                    placeholder="Email"
                    ref={inputRefs.current["email"]}
                    type="email"
                    name="Email"
                    onChange={(e) => validate(e.target)}
                  />
                </div>
                <div className="col-md-12">
                  <input
                    className="contactusmess"
                    placeholder="Message"
                    ref={inputRefs.current["msg"]}
                    type="text"
                    onChange={(e) => validate(e.target)}
                  />
                </div>
                <div className="col-md-12">
                  <button type="submit" className="send_btn">
                    Send
                  </button>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
      <div className="container-fluid">
        <div className="map_section">
          <div id="map"></div>
        </div>
      </div>
    </div>
  );
};

export default Contact;
