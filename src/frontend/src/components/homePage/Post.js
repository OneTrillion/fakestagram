import "./Post.css";
import AccountCircleRoundedIcon from "@mui/icons-material/AccountCircleRounded";
import selfie from "../images/upload-selfie.jpg";
import MoreVertIcon from '@mui/icons-material/MoreVert';
import SendIcon from "@mui/icons-material/Send";
import 'bootstrap/dist/css/bootstrap.min.css';
import FavoriteBorderIcon from '@mui/icons-material/FavoriteBorder';
import BookmarkBorderIcon from '@mui/icons-material/BookmarkBorder';
import SentimentSatisfiedAltIcon from '@mui/icons-material/SentimentSatisfiedAlt';
import ChatBubbleOutlineIcon from '@mui/icons-material/ChatBubbleOutline';
import SideSuggestions from "./SideSuggestions";
import {Component, useEffect, useState} from "react";
import {deletePost, likePost} from "../../client";
import Comments from "../comments/Comments";

function Post({postInfo}) {

    const [post, setPost] = useState({postInfo})

const fetchDeletePost =() =>{
       // deletePost(postInfo.id)
}

const fetchLikePost =()=>{
       // likePost(postInfo.id)
}

        return(
        <div className="feed">

            {/*Post section*/}
            <div className="post-cont">
                <div className="post">
                    <div className="user-cont">

                        <div className="profile-img-cont"><AccountCircleRoundedIcon sx={{ fontSize: 50 }}/> </div>
                        <p className="user-n">username</p>
                        <div className="more"><button className="delete-post" onClick={fetchDeletePost}>Delete post</button></div>
                    </div>
                    <div className="post-img-cont">
                        <img className="post-img" src=""/>
                    </div>

                    {/*Post description section*/}
                    <div className="post-description">
                        <div className="icons-cont">
                            <div className="like-icon"><FavoriteBorderIcon />{fetchLikePost()}</div>
                            <div className="comment-icon"><a href=""><ChatBubbleOutlineIcon/></a></div>
                            <div className="share-icon"><a href=""><SendIcon/></a></div>
                            <div className="save-icon"><a href=""><BookmarkBorderIcon/></a></div>
                        </div>
                        <div className="likes-amount"> likes</div>
                        <div className="desc-cont">
                            <p className="user-n"><a href="url">Username</a></p>
                            <div className="desc-text">description text here
                            </div>
                        </div>
                        <Comments/>
                    </div>
                </div>
            </div>

        </div>
        );

}

export default Post;