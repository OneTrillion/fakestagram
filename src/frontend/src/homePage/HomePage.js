import "./HomePage.css";
import Header from "../header/Header";
import UserStories from "./UserStories";
import Feed from "./Feed"


function HomePage(){
    return(
        <div className="HomePage">
        <Header/>
            <UserStories/>
            <Feed/>


        </div>
    )
}
export default HomePage;