import Header from "../header/Header";
import "./CurrentUserProfile.css";
import AccountCircleRoundedIcon from "@mui/icons-material/AccountCircleRounded";
import SettingsIcon from '@mui/icons-material/Settings';
import {useEffect, useState} from "react";
import {getCurrentUserInfo, getPostsByUserId} from "../../client";
import Post from "../homePage/Post";


function CurrentUserProfile({userInfo}) {

    const [currentUser, setCurrentUser] = useState({});
    const [posts, setPosts] = useState([{}])

    const fetchCurrentUserInfo = () =>{
        getCurrentUserInfo()
            .then(res => res.json())
            .then(data => {
                setCurrentUser(data)
                console.log(data)
            })
            .catch(err => console.log(err))
    }

    useEffect(() => {
        fetchCurrentUserInfo()
    }, []);



   const fetchPostsByUserId =() =>{
       getPostsByUserId(1)
           .then(res => res.json())
           .then(data => {
               setPosts(data)
               console.log(data)
           })
           .catch(err => console.log(err))
   }

    useEffect(() => {
        fetchPostsByUserId()
    }, []);




    return(
        <div className="user-profile">
            <Header/>
            <div className="top-profile-cont">
                <div className="top-profile-img"> <img className="profile-pic-img" src={`${currentUser.profilePicturePath}`}width="150" height="150"/>
                </div>

                <div className="side-info-cont">
                    <div className="profile-info-cont">
                        <div className="profile-username">{currentUser.username}</div>
                        <button className="edit-profile">Edit profile</button>
                        <div className="icon-settings"><SettingsIcon/></div>
                    </div>

                    <div className="status-cont">
                        <div className="post-count">{posts.length} posts</div>
                        <div className="followers-count">{currentUser.followerIds} followers</div>
                        <div className="following-count"> {currentUser.followingIds} following</div>

                    </div>

                    <div className="user-desc-cont">
                       <div className="ind-name">Name: {currentUser.name}</div>
                        <div className="ind-age">Age: {currentUser.age}</div>
                    </div>
                    <div className="bio-text">{currentUser.bio}</div>

                </div>
            </div>

            <div className="bottom-profile-cont">
                POSTS:

                <div className="user-post-cont">

                    <div className="post-box">
                        {posts.map((post) => <div key={post.id}><Post postInfo={post}/></div>)}

                    </div>


                </div>

            </div>
            </div>

    );

}

export default CurrentUserProfile;