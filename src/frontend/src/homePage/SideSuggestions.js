import AccountCircleRoundedIcon from "@mui/icons-material/AccountCircleRounded";
import "./SideSuggestions.css"

function SideSuggestions() {

    return(
        <div className="side-suggestions">
                 <div className="side-suggestions-cont">
            <div className="user-profile-box">
                <AccountCircleRoundedIcon sx={{ fontSize: 45 }}/>
            </div>
            <p className="user-n"><a href="url">Username</a></p>
                <div className="follow">
                    <a href="url">Follow </a>
                </div>

            </div>

        </div>
    );

}

export default SideSuggestions;