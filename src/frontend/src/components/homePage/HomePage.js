import "./HomePage.css";
import Header from "../header/Header";
import UserStories from "./UserStories";
import Post from "./Post"
import SideSuggestions from "./SideSuggestions";
import {useEffect, useState} from "react";
import {getAllPosts, getCurrentUserInfo} from "../../client";


function HomePage(){

  const [posts, setPosts] = useState([{}]);

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


    return(
        <div className="HomePage">
        <Header/>
            <UserStories/>
            {posts.map((post) => <div key={post.id}><Post postInfo={post}/></div>)}
            <Post/>
            <Post/>
            <Post/>

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