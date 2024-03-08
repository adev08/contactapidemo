import React from "react";
import "./App.css";
import Header from "./components/Header";
import ContactList from "./components/ContactList";
import { getContacts } from "./api/ContactService";
import { Routes, Route, Navigate } from "react-router-dom";

function App() {
  const [data, setData] = React.useState({});
  const [currentPage, setCurrentPage] = React.useState(0);

  const getAllContacts = async (page = 0, size = 10) => {
    try {
      setCurrentPage(page);
      const { data } = await getContacts(page, size);
      setData(data);
      console.log(data);
    } catch (error) {
      console.error(error);
    }
  };

  const toogleModal = (show) => {
    console.log("clicked");
  };

  React.useEffect(() => {
    getAllContacts();
  }, []);

  return (
    <>
      <Header toogleModal={toogleModal} numbOfContacts={data.totalElements} />
      <main className="main">
        <div className="container">
          <Routes>
            <Route path="/" element={<Navigate to={"/contacts"} />} />
            <Route
              path="/contacts"
              element={
                <ContactList
                  data={data}
                  currentPage={currentPage}
                  getAllContacts={getAllContacts}
                />
              }
            />
          </Routes>
        </div>
      </main>
    </>
  );
}

export default App;
