import "./Feed.css";
import AccountCircleRoundedIcon from "@mui/icons-material/AccountCircleRounded";
import selfie from "../images/upload-selfie.jpg";
function Feed(src, desc, timestamp,likes) {

    return (
        <div className="feed">
            <div className="post">
                <div className="user-cont">
                    <AccountCircleRoundedIcon sx={{ fontSize: 45 }}/>
                    <p className="user-n">LilBaybay</p>
                </div>
                <div className="post-img-cont">
                <img className="post-img" src="https://i.pinimg.com/564x/30/c0/e6/30c0e6be1be0d6635b82370359b2e7cb.jpg" />
            </div>
                <div className="post-description">
                    <p className="user-n">Username</p>
                    <div className="desc-text">
                        This is a post description</div>
                </div>
            </div>


            <div className="post">
                <div className="user-cont">
                    <AccountCircleRoundedIcon sx={{ fontSize: 45 }}/>
                    <p className="user-n">KyliesAss</p>
                </div>
                <div className="post-img-cont">
                    <img className="post-img" src="https://i.pinimg.com/564x/83/c6/96/83c69622a53af8664ba607c9745bdb49.jpg" />
                </div>
                <div className="post-description">
                    <p className="user-n">Username</p>
                    <div className="desc-text">
                        This is a post description</div>
                </div>
            </div>

            <div className="post">
                <div className="user-cont">
                    <AccountCircleRoundedIcon sx={{ fontSize: 45 }}/>
                    <p className="user-n">Username</p>
                </div>
                <div className="post-img-cont">
                    <img className="post-img" src={selfie} alt="" />
                </div>
                <div className="post-description">
                    <p className="user-n">Username</p>
                    <div className="desc-text">
                        This is a post description</div>
                </div>
            </div>
            <div className="post">
                <div className="user-cont">
                    <AccountCircleRoundedIcon sx={{ fontSize: 45 }}/>
                    <p className="user-n">Username</p>
                </div>
                <div className="post-img-cont">
                    <img className="post-img" src={selfie} alt="" />
                </div>
                <div className="post-description">
                    <p className="user-n">Username</p>
                    <div className="desc-text">
                        This is a post description</div>
                </div>
            </div>
        </div>

    );
}

export default Feed;