import Header from "../header/Header";
import "./UserProfile.css";
import AccountCircleRoundedIcon from "@mui/icons-material/AccountCircleRounded";
import SettingsIcon from '@mui/icons-material/Settings';
import {useEffect, useState} from "react";
import {getCurrentUserInfo, getPostsByUserId} from "../../client";


function UserProfile() {

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
           .then(data=> setPosts(data))
           .catch(err => console.log(err))
   }



    return(
        <div className="user-profile">
            <Header/>
            <div className="top-profile-cont">
                <div className="top-profile-img"> <img src={`${user.profilePicturePath}`}width="150" height="150"/>
                </div>

                <div className="side-info-cont">
                    <div className="profile-info-cont">
                        <div className="profile-username">{user.username}</div>
                        <button className="follow-user">Follow {} </button>
                        <div className="icon-settings"><SettingsIcon/></div>
                    </div>

                    <div className="status-cont">
                        <div className="post-count">3 Posts</div>
                        <div className="followers-count">{user.followersId}</div>
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
                        {posts.img}
                        {posts.description}
                    </div>
                    <div className="post-box">
                        {posts.img}
                        {posts.description}
                        <img className="user-post-img" src="https://i.pinimg.com/564x/30/c0/e6/30c0e6be1be0d6635b82370359b2e7cb.jpg"/>
                    </div>
                    <div className="post-box">
                        {posts.img}
                        {posts.description}
                        <img className="user-post-img" src="https://i.pinimg.com/564x/30/c0/e6/30c0e6be1be0d6635b82370359b2e7cb.jpg"/>
                    </div>

                </div>


            </div>

        </div>

    );

}

export default UserProfile;