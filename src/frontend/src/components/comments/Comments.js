import SentimentSatisfiedAltIcon from "@mui/icons-material/SentimentSatisfiedAlt";
import AccountCircleRoundedIcon from "@mui/icons-material/AccountCircleRounded";
import FavoriteBorderIcon from "@mui/icons-material/FavoriteBorder";
import ChatBubbleOutlineIcon from "@mui/icons-material/ChatBubbleOutline";
import SendIcon from "@mui/icons-material/Send";
import BookmarkBorderIcon from "@mui/icons-material/BookmarkBorder";

function Comments() {


    return(
        <div className="comments">

            {/*Comment section*/}
            <div className="posted-comments-cont">
                <p className="user-n"><a href="">Username :</a></p>
                <div className="comment-posted">this is a comment</div>
            </div>

            {/*Post a comment*/}
            <div className="comment-cont">
                <div className="smiley-icon"><SentimentSatisfiedAltIcon sx={{fontSize: 28}}/></div>
                <div className="comment"><input type="text" placeholder="Add a commment..."></input></div>
                <p className="post-comment"><a href="">Post</a></p>
            </div>
        </div>
    );

}
export default Comments;