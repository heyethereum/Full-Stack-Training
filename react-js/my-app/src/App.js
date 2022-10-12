import { BrowserRouter, Routes, Route } from "react-router-dom";
import { useState } from "react";
import Home from "./pages/Home";
import About from "./pages/About";
import Products from "./pages/Products";
import Error from "./pages/Error";
import SharedLayout from "./pages/SharedLayout";
import SingleProduct from "./pages/SingleProduct";
import Dashboard from "./pages/Dashboard";
import Login from "./pages/Login";
import ProtectedRoute from "./pages/ProtectedRoute";
import SharedProductLayout from "./pages/SharedProductLayout";
import PostAPI from "./pages/PostAPI";
import ClassPostAPIs from "./pages/ClassPostAPIs";
import Age from "./pages/Age";
import ClassAge from "./pages/ClassAge";
import AllUsers from "./pages/AllUsers";
import ClassAllUsers from "./pages/ClassAllUsers";
import FindUserById from "./pages/FindUserById";
import Register from "./pages/Register";
import LoginDB from "./pages/LoginDB";
import UpdateDeleteDB from "./pages/UpdateDeleteDB";

function App() {
  const [user, setUser] = useState(null);
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<SharedLayout />}>
          <Route index element={<Home />} />
          <Route path="/home" element={<Home />} />
          <Route path="/about" element={<About />} />
          <Route path="/postApi" element={<PostAPI />} />
          <Route path="/classPostAPI" element={<ClassPostAPIs />} />
          <Route path="/classAge" element={<ClassAge />} />
          <Route path="/age" element={<Age />} />
          <Route path="/users" element={<AllUsers />} />
          <Route path="/classAllUsers" element={<ClassAllUsers />} />
          <Route path="/findUserById" element={<FindUserById />} />
          <Route path="/register" element={<Register />} />
          <Route
            path="/loginDB"
            element={<LoginDB Login setUser={setUser} />}
          />
          <Route path="/updateDeleteDB" element={<UpdateDeleteDB />} />

          <Route path="/products" element={<SharedProductLayout />}>
            <Route index element={<Products />} />
            <Route path=":productId" element={<SingleProduct />} />
          </Route>

          <Route path="/login" element={<Login setUser={setUser}></Login>} />
          <Route
            path="/dashboard"
            element={
              <ProtectedRoute user={user}>
                <Dashboard user={user} />
              </ProtectedRoute>
            }
          />
          <Route path="*" element={<Error />} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
