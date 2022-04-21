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
import {deletePost, getUserByUserId, likePost, unlikePost} from "../../client";
import Comments from "../comments/Comments";

function Post({postInfo}) {

    const [user, setUser] = useState({})
    const [like, setLike] = useState(true)



const fetchDeletePost =() =>{
       deletePost(postInfo.id)
           .catch(err => console.log(err))
}

const fetchLikePost =()=>{
       likePost(postInfo.id)
           .catch(err => console.log(err))
           setLike(false)
}

const fetchUnlikePost =()=>{
        unlikePost(postInfo.id)
            .catch(err => console.log(err))
    setLike(true)
}

const likeToggle =()=>{
        if(like) fetchLikePost()
    else fetchUnlikePost()
}


    const fetchUserByUserId = ()=>{
        getUserByUserId(postInfo.userId)
            .then(res => res.json())
            .then(data => setUser(data))
            .catch(err => console.log(err))

    }

    useEffect(() => {
        console.log(postInfo.userId)
        fetchUserByUserId()
    }, [postInfo]);


const calcLength = (obj) => {
    if (obj === null || obj === undefined || obj.length === 0) return 0;
    return Object.keys(obj).length;
}

        return(
        <div className="feed">

            {/*Post section*/}
            <div className="post-cont">
                <div className="post">
                    <div className="user-cont">

                        <div className="profile-img-cont"><img className="user-prof-img" src={`${user.profilePicturePath}`}width="50" height="50"/> </div>
                        <p className="user-n">{user.username}</p>
                        <div className="more"><button className="delete-post" onClick={fetchDeletePost}>Delete post</button></div>
                    </div>
                    <div className="post-img-cont">
                        <img className="post-img" src={`${postInfo.img}`}/>
                    </div>

                    {/*Post description section*/}
                    <div className="post-description">
                        <div className="icons-cont">
                            <div className="like-icon"><FavoriteBorderIcon onClick={likeToggle}/></div>
                            <div className="comment-icon"><a href=""><ChatBubbleOutlineIcon/></a></div>
                            <div className="share-icon"><a href=""><SendIcon/></a></div>
                            <div className="save-icon"><a href=""><BookmarkBorderIcon/></a></div>
                        </div>
                        <div className="likes-amount">{calcLength(postInfo.likedByUser)} likes</div>
                        <div className="desc-cont">
                            <p className="user-n">{user.username}</p>
                            <div className="desc-text">{postInfo.description}
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