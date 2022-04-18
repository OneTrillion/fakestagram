import "./Feed.css";
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

function Feed() {

    return (
        <div className="feed">

            <div className="post-cont">
            <div className="post">
                <div className="user-cont">
                    <AccountCircleRoundedIcon sx={{ fontSize: 45 }}/>
                    <p className="user-n"><a href="url">Username</a></p>
                    <div className="more"><a href="url"><MoreVertIcon/></a></div>
                </div>
                <div className="post-img-cont">
                <img className="post-img" src="https://i.pinimg.com/564x/30/c0/e6/30c0e6be1be0d6635b82370359b2e7cb.jpg" />
            </div>
                <div className="post-description">
                    <div className="icons-cont">
                        <div className="like-icon"><a href="url"><FavoriteBorderIcon/></a></div>
                        <div className="comment-icon"><a href="url"><ChatBubbleOutlineIcon/></a></div>
                        <div className="share-icon"><a href="url"><SendIcon/></a></div>
                        <div className="save-icon"><a href="url"><BookmarkBorderIcon/></a></div>
                    </div>
                    <div className="likes-amount">2,354 likes</div>
                    <div className="desc-cont">
                    <p className="user-n"><a href="url">Username</a></p>
                    <div className="desc-text">
                        This is a post description</div>
                    </div>
                </div>
                <div className="comment-cont">
                    <div className="smiley-icon"><SentimentSatisfiedAltIcon sx={{ fontSize: 28 }}/></div>
                    <div className="comment"><input type="text"placeholder="Add a commment..."></input></div>
                    <p className="post-comment"><a href="url">Post</a></p>
                </div>
            </div>


            <div className="post">
                <div className="user-cont">
                    <AccountCircleRoundedIcon sx={{ fontSize: 45 }}/>
                    <p className="user-n"><a href="url">Username</a></p>
                    <div className="more"><a href="url"><MoreVertIcon/></a></div>
                </div>
                <div className="post-img-cont">
                    <img className="post-img" src="https://i.pinimg.com/564x/83/c6/96/83c69622a53af8664ba607c9745bdb49.jpg" />
                </div>
                <div className="icons-cont">
                    <div className="like-icon"><a href="url"><FavoriteBorderIcon/></a></div>
                    <div className="comment-icon"><a href="url"><ChatBubbleOutlineIcon/></a></div>
                    <div className="share-icon"><a href="url"><SendIcon/></a></div>
                    <div className="save-icon"><a href="url"><BookmarkBorderIcon/></a></div>
                </div>
                <div className="likes-amount">2,354 likes</div>
                <div className="desc-cont">
                    <p className="user-n"><a href="url">Username</a></p>
                    <div className="desc-text">
                        This is a post description</div>
                </div>
                <div className="comment-cont">
                    <div className="smiley-icon"><SentimentSatisfiedAltIcon sx={{ fontSize: 28 }}/></div>
                    <div className="comment"><input type="text"placeholder="Add a commment..."></input></div>
                    <p className="post-comment"><a href="url">Post</a></p>
                </div>
            </div>

            <div className="post">
                <div className="user-cont">
                    <AccountCircleRoundedIcon sx={{ fontSize: 45 }}/>
                    <p className="user-n"><a href="url">Username</a></p>
                    <div className="more"><a href="url"><MoreVertIcon/></a></div>
                </div>
                <div className="post-img-cont">
                    <img className="post-img" src={selfie} alt="" />
                </div>
                <div className="icons-cont">
                    <div className="like-icon"><a href="url"><FavoriteBorderIcon/></a></div>
                    <div className="comment-icon"><a href="url"><ChatBubbleOutlineIcon/></a></div>
                    <div className="share-icon"><a href="url"><SendIcon/></a></div>
                    <div className="save-icon"><a href="url"><BookmarkBorderIcon/></a></div>
                </div>
                <div className="likes-amount">2,354 likes</div>
                <div className="desc-cont">
                    <p className="user-n"><a href="url">Username</a></p>
                    <div className="desc-text">
                        This is a post description</div>
                </div>
                <div className="comment-cont">
                    <div className="smiley-icon"><SentimentSatisfiedAltIcon sx={{ fontSize: 28 }}/></div>
                    <div className="comment"><input type="text"placeholder="Add a commment..."></input></div>
                    <p className="post-comment"><a href="url">Post</a></p>
                </div>
            </div>
            <div className="post">
                <div className="user-cont">
                    <AccountCircleRoundedIcon sx={{ fontSize: 45 }}/>
                    <p className="user-n"><a href="url">Username</a></p>
                    <div className="more"><a href="url"><MoreVertIcon/></a></div>
                </div>
                <div className="post-img-cont">
                    <img className="post-img" src={selfie} alt="" />
                </div>
                <div className="icons-cont">
                    <div className="like-icon"><a href="url"><FavoriteBorderIcon/></a></div>
                    <div className="comment-icon"><a href="url"><ChatBubbleOutlineIcon/></a></div>
                    <div className="share-icon"><a href="url"><SendIcon/></a></div>
                    <div className="save-icon"><a href="url"><BookmarkBorderIcon/></a></div>
                </div>
                <div className="likes-amount">2,354 likes</div>
                <div className="desc-cont">
                    <p className="user-n"><a href="url">Username</a></p>
                    <div className="desc-text">
                        This is a post description</div>
                </div>
                <div className="comment-cont">
                    <div className="smiley-icon"><SentimentSatisfiedAltIcon sx={{ fontSize: 28 }}/></div>
                    <div className="comment"><input type="text"placeholder="Add a commment..."></input></div>
                    <p className="post-comment"><a href="url">Post</a></p>
                </div>
            </div>
            </div>
            <div className="side-cont">
                <p className="suggestions-title">Suggestions for you</p>
                <SideSuggestions/>
                <SideSuggestions/>
                <SideSuggestions/>
                <SideSuggestions/>
                <SideSuggestions/>
            </div>

        </div>

    );
}

export default Feed;