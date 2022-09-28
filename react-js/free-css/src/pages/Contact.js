import React from "react";
import Footer from "../components/Footer";
import Header from "../components/Header";
import ContactComponent from "../components/Contact";

const Contact = () => {
  return (
    <div class="main-layout position_head">
      <Header />
      <ContactComponent />
      <Footer />
    </div>
  );
};

export default Contact;
