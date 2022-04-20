import Header from "../header/Header";
//import "./SignedInUserProfile.css";
import AccountCircleRoundedIcon from "@mui/icons-material/AccountCircleRounded";
import SettingsIcon from '@mui/icons-material/Settings';
import {useEffect, useState} from "react";
import {getCurrentUserInfo} from "../../client";


function SignedInUserProfile() {

const [user, setUser] = useState({});
const fetchCurrentUserInfo = () =>{
    getCurrentUserInfo()
        .then(res => res.json())
        .then(data => setUser(data))
        .catch(err => console.log(err))
}

    useEffect(() => {
        fetchCurrentUserInfo()
    }, []);




    return(
        <div className="user-profile">
            <Header/>
            <div className="top-profile-cont">
                <div className="top-profile-img"> <AccountCircleRoundedIcon/>
                </div>

                <div className="side-info-cont">
                <div className="profile-info-cont">
                    <div className="profile-username">{user.username}</div>
                    <button className="edit-profile">Edit profile </button>
                    <div className="icon-settings"><SettingsIcon/></div>
                </div>

                    <div className="status-cont">
                        <div className="post-count">3 Posts</div>
                        <div className="followers-count">5243 followers</div>
                        <div className="following-count">243 following</div>

                    </div>

                    <div className="user-desc-cont">
                        <p>This is a profile description.This is a profile description. This is a profile description. This is a profile description.
                            This is a profile description.</p>
                    </div>


                </div>
            </div>

            <div className="bottom-profile-cont">
                POSTS:

                <div className="user-post-cont">

                    <div className="post-box">
                        <img className="user-post-img" src="https://i.pinimg.com/564x/30/c0/e6/30c0e6be1be0d6635b82370359b2e7cb.jpg"/>
                    </div>
                    <div className="post-box">
                        <img className="user-post-img" src="https://i.pinimg.com/564x/30/c0/e6/30c0e6be1be0d6635b82370359b2e7cb.jpg"/>
                    </div>
                    <div className="post-box">
                        <img className="user-post-img" src="https://i.pinimg.com/564x/30/c0/e6/30c0e6be1be0d6635b82370359b2e7cb.jpg"/>
                    </div>

                </div>


                </div>

            </div>

    );

}

export default SignedInUserProfile;