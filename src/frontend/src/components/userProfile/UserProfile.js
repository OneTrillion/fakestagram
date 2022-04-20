import Header from "../header/Header";
import "./UserProfile.css";
import AccountCircleRoundedIcon from "@mui/icons-material/AccountCircleRounded";
import SettingsIcon from '@mui/icons-material/Settings';
import {useEffect, useState} from "react";
import {getCurrentUserInfo, getUserInfoByUsername} from "../../client";
import Post from "../homePage/Post";
import post from "../homePage/Post";


function UserProfile() {

const [user, setUser] = useState({});

const fetchGetUserInfoByUsername = () =>{
    getUserInfoByUsername("LoveIsLife")
        .then(res => res.json())
        .then(data => setUser(data))
        .catch(err => console.log(err))
}

    useEffect(() => {
        fetchGetUserInfoByUsername()
    }, []);




    return(
        <div className="user-profile">
            <Header/>
            <div className="top-profile-cont">
                <div className="top-profile-img"> <img className="profile-pic-img" src={`${user.profilePicturePath}`}width="150" height="150"/>
                </div>
                <div className="side-info-cont">
                <div className="profile-info-cont">
                    <div className="profile-username">{user.username}</div>
                    <button className="follow-user">Follow </button>
                </div>

                    <div className="status-cont">
                        <div className="post-count">{post.length} Posts</div>
                        <div className="followers-count">{user.followerIds} followers</div>
                        <div className="following-count">{user.followingIds} following</div>

                    </div>

                    <div className="user-desc-cont">
                        <div className="us-name">Name: {user.name}</div>
                        <div className="us-age">Age: {user.age}</div>
                    </div>

                    <div className="bio-text">{user.bio}</div>
                </div>
            </div>

            <div className="bottom-profile-cont">
                POSTS:

                <div className="user-post-cont">

                    <div className="post-box">



                    </div>

                </div>


                </div>

            </div>

    );

}

export default UserProfile;