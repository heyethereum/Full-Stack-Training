import React, { useRef } from "react";
import Footer from "../components/Footer";
import Header from "../components/Header";

const Contact = () => {
  const inputRefs = useRef({
    name: React.createRef(),
    email: React.createRef(),
    subject: React.createRef(),
    msg: React.createRef(),
  });
  const validate = (obj) => {
    if (!obj.value) obj.focus();
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
    <div id="page">
      <Header isActive="contact" />
      <div id="body" className="contact">
        <div className="header">
          <div>
            <h1>Contact</h1>
          </div>
        </div>
        <div className="body">
          <div>
            <div>
              <img src="images/check-in.png" alt="" />
              <h1>UNIT 0123 , ABC BUILDING, BUSSINESS PARK</h1>
              <p>
                If you're having problems editing this website template, then
                don't hesitate to ask for help on the Forums.
              </p>
            </div>
          </div>
        </div>
        <div className="footer">
          <div className="contact">
            <h1>INQUIRY FORM</h1>
            <form onSubmit={handleSubmit}>
              <input
                type="text"
                ref={inputRefs.current["name"]}
                placeholder="Name"
              />
              <input
                type="email"
                ref={inputRefs.current["email"]}
                placeholder="Email"
              />
              <input
                type="text"
                ref={inputRefs.current["subject"]}
                placeholder="Subject"
              />
              <textarea
                ref={inputRefs.current["msg"]}
                cols="50"
                rows="7"
                placeholder="Share your thoughts"
              />
              <input type="submit" value="Send" id="submit" />
            </form>
          </div>
          <div className="section">
            <h1>WE’D LOVE TO HEAR FROM YOU.</h1>
            <p>
              If you're having problems editing this website template, then
              don't hesitate to ask for help on the Forums.
            </p>
          </div>
        </div>
      </div>
      <Footer />
    </div>
  );
};

export default Contact;
