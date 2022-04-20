import Header from "../header/Header";
import "./CurrentUserProfile.css";
import AccountCircleRoundedIcon from "@mui/icons-material/AccountCircleRounded";
import SettingsIcon from '@mui/icons-material/Settings';
import {useEffect, useState} from "react";
import {getCurrentUserInfo, getPostsByUserId} from "../../client";


function CurrentUserProfile() {

    const [user, setUser] = useState({});
    const [posts, setPosts] = useState({})

    const fetchCurrentUserInfo = () =>{
        getCurrentUserInfo()
            .then(res => res.json())
            .then(data => {
                setUser(data)
                console.log(data)
            })
            .catch(err => console.log(err))
    }

    useEffect(() => {
        fetchCurrentUserInfo()
    }, []);



   const fetchPostsById =() =>{
       getPostsByUserId(2)
           .then(res => res.json())
           .then(data=>{
               setPosts(data)
               console.log(data)
           })
           .catch(err => console.log(err))
   }



    return(
        <div className="user-profile">
            <Header/>
            <div className="top-profile-cont">
                <div className="top-profile-img"> <img className="profile-pic-img" src={`${user.profilePicturePath}`}width="150" height="150"/>
                </div>

                <div className="side-info-cont">
                    <div className="profile-info-cont">
                        <div className="profile-username">{user.username}</div>
                        <button className="edit-profile">Edit profile</button>
                        <div className="icon-settings"><SettingsIcon/></div>
                    </div>

                    <div className="status-cont">
                        <div className="post-count">3 Posts</div>
                        <div className="followers-count">{user.followersId} followers</div>
                        <div className="following-count"> following</div>

                    </div>

                    <div className="user-desc-cont">
                       <div className="ind-name">Name: {user.name}</div>
                        <div className="ind-age">Age: {user.age}</div>
                    </div>
                    <div className="bio-text">{user.bio}</div>

                </div>
            </div>

            <div className="bottom-profile-cont">
                POSTS:

                <div className="user-post-cont">

                    <div className="post-box">
                        <img className="posts-frame" src={`${posts.img}`}width="255" height="255"/>
                        <img className="posts-frame" src={`${posts.id}`}width="250" height="250"/>
                        <img className="posts-frame" src={`${posts.id}`}width="250" height="250"/>

                    </div>


                </div>

            </div>
            </div>

    );

}

export default CurrentUserProfile;