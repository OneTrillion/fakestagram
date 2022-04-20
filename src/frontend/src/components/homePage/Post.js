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
import {getAllPosts} from "../../client";

function Post({postInfo}) {



        return(
        <div className="feed">

            {/*Post section*/}
            <div className="post-cont">
                <div className="post">
                    <div className="user-cont">
                        <div className="profile-img-cont"><AccountCircleRoundedIcon sx={{ fontSize: 50 }}/> </div>
                        <p className="user-n">username</p>
                        <div className="more"><a href="url"><MoreVertIcon/></a></div>
                    </div>
                    <div className="post-img-cont">
                        <img className="post-img" src=""/>
                    </div>

                    {/*Post description section*/}
                    <div className="post-description">
                        <div className="icons-cont">
                            <div className="like-icon"><a href="url"><FavoriteBorderIcon/></a></div>
                            <div className="comment-icon"><a href="url"><ChatBubbleOutlineIcon/></a></div>
                            <div className="share-icon"><a href="url"><SendIcon/></a></div>
                            <div className="save-icon"><a href="url"><BookmarkBorderIcon/></a></div>
                        </div>
                        <div className="likes-amount">1324 likes</div>
                        <div className="desc-cont">
                            <p className="user-n"><a href="url">Username</a></p>
                            <div className="desc-text">this is a desc
                            </div>
                        </div>
                    </div>


                    {/*Comment section*/}
                    <div className="posted-comments">
                        <p className="user-n"><a href="url">Username :</a></p>
                        <div className="comment-posted">this is a comment</div>
                    </div>

                    {/*Post a comment*/}
                    <div className="comment-cont">
                        <div className="smiley-icon"><SentimentSatisfiedAltIcon sx={{fontSize: 28}}/></div>
                        <div className="comment"><input type="text" placeholder="Add a commment..."></input></div>
                        <p className="post-comment"><a href="url">Post</a></p>
                    </div>
                </div>
            </div>

        </div>
        );

}

export default Post;