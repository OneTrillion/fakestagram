import {Dropdown} from "react-bootstrap";
import HomeIcon from "@mui/icons-material/Home";
import AddBoxIcon from "@mui/icons-material/AddBox";
import SendIcon from "@mui/icons-material/Send";
import AccountCircleRoundedIcon from "@mui/icons-material/AccountCircleRounded";
import 'bootstrap/dist/css/bootstrap.min.css';
import ExploreIcon from '@mui/icons-material/Explore';
import FavoriteBorderIcon from '@mui/icons-material/FavoriteBorder';
import PermIdentityRoundedIcon from '@mui/icons-material/PermIdentityRounded';
import BookmarkBorderIcon from '@mui/icons-material/BookmarkBorder';
import SettingsIcon from '@mui/icons-material/Settings';
import "./Nav.css";

function Nav() {
    return(
        <div className="nav">
                <Dropdown>

                    <div className="dropdown-icons-cont">
                        <div className="home-icon"><a href="url"><HomeIcon/></a></div>
                        <div className="send-icon"> <a href="url"><SendIcon/></a></div>
                        <div className="add-box-icon"><a href="url"><AddBoxIcon/></a></div>
                        <div className="explore-icon"><a href="url"><ExploreIcon/></a></div>
                        <div className="favorite-border-icon"><a href="url"><FavoriteBorderIcon/></a></div>

                    <Dropdown.Toggle id="example1" variant="">
                        <AccountCircleRoundedIcon/>
                    </Dropdown.Toggle>

                    <Dropdown.Menu variant="">
                        <Dropdown.Item href="#/action-2"><PermIdentityRoundedIcon/> Profile</Dropdown.Item>
                        <Dropdown.Item href="#/action-3"><BookmarkBorderIcon/> Saved</Dropdown.Item>
                        <Dropdown.Item href="#/action-4"><SettingsIcon/> Settings</Dropdown.Item>
                        <Dropdown.Divider />
                        <Dropdown.Item href="#/action-4">Log Out</Dropdown.Item>
                    </Dropdown.Menu>
                    </div>
                </Dropdown>





        </div>
    );


}
export default Nav;