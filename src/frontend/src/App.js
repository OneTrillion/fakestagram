import './App.css';
import {BrowserRouter as Router, Routes, Link, Route} from "react-router-dom";
import LoginPage from "./components/loginPage/LoginPage";
import HomePage from "./components/homePage/HomePage";
import RegisterPage from "./components/registerPage/RegisterPage";
import SignedInUserProfile from "./components/signedInUserProfile/SignedInUserProfile";
import UserProfile from "./components/userProfile/UserProfile";
import PostPage from "./components/postPage/PostPage";

function App() {



  return (
      <Router>
          <div className="App">
              <Routes>
                  <Route path={"/register"} element={
                      <>
                          <RegisterPage />
                      </>
                  }/>
                  <Route path={"/"} element={
                      <>
                          <HomePage />
                      </>
                  }/>
                  <Route path={"/my-page"} element={
                      <>
                          <SignedInUserProfile />
                      </>
                  }/>
                  <Route path={"/friend-page"} element={
                      <>
                          <UserProfile />
                      </>
                  }/>
                  <Route path={"/post-page"} element={
                      <>
                          <PostPage />
                      </>
                  }/>
              </Routes>
          </div>
      </Router>
  );
}

export default App;
