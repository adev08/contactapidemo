import React from "react";

const Header = ({ toggleModal, numbOfContacts }) => {
  return (
    <header className="header">
      <div className="container">
        <h3>Contact List ({numbOfContacts})</h3>
        <button onClick={() => toggleModal(true)} className="btn">
          <i className="bi bi-plus-square"></i> Add New Contact
        </button>
      </div>
    </header>
  );
};

export default Header;
