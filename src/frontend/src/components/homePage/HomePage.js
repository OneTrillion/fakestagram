import "./HomePage.css";
import Header from "../header/Header";
import UserStories from "./UserStories";
import Post from "./Post"
import SideSuggestions from "./SideSuggestions";
import {useEffect, useState} from "react";
import {getAllPosts, getCurrentUserInfo} from "../../client";


function HomePage(){

  const [posts, setPosts] = useState([{}]);

  const mapPosts = posts.map((info) => {
      return(
          <>
              <Post postInfo={info}/>
          </>
      )
  })

  const fetchAllPosts = () => {
      getAllPosts()
            .then(res => res.json())
            .then(data => {
                setPosts(data)
                console.log(data)
            })
            .catch(err => console.log(err))
    }
    useEffect(() => {
        fetchAllPosts()
    }, []);



//{posts.map((t) =>
//                 posts[t].map((e) => <div key={e.id}><Post postInfo={e}/></div>))}
    return(
        <div className="HomePage">
        <Header/>
            <UserStories/>
            {mapPosts}

            <div className="side-cont">
                <p className="suggestions-title">Suggestions for you</p>
                <SideSuggestions/>
                <SideSuggestions/>
                <SideSuggestions/>
                <SideSuggestions/>
                <SideSuggestions/>
            </div>


        </div>
    )
}
export default HomePage;