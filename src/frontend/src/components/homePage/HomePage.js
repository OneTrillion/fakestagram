import "./HomePage.css";
import Header from "../header/Header";
import UserStories from "./UserStories";
import Post from "./Post"
import SideSuggestions from "./SideSuggestions";


function HomePage(){
    return(
        <div className="HomePage">
        <Header/>
            <UserStories/>
            <Post/>
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