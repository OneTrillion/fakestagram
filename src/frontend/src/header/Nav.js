import {Dropdown} from "react-bootstrap";
import HomeIcon from "@mui/icons-material/Home";
import AddBoxIcon from "@mui/icons-material/AddBox";
import SendIcon from "@mui/icons-material/Send";
import AccountCircleRoundedIcon from "@mui/icons-material/AccountCircleRounded";
import 'bootstrap/dist/css/bootstrap.min.css';
import ExploreIcon from '@mui/icons-material/Explore';
import FavoriteBorderIcon from '@mui/icons-material/FavoriteBorder';
import "./Nav.css";

function Nav() {
    return(
        <div className="nav">
                <Dropdown>

                    <div className="dropdown-icons-cont">
                        <div className="home-icon"><HomeIcon/></div>
                        <div className="send-icon"> <SendIcon/></div>
                        <div className="add-box-icon"><AddBoxIcon/></div>
                        <div className="explore-icon"><ExploreIcon/></div>
                        <div className="favorite-border-icon"> <FavoriteBorderIcon/></div>

                    <Dropdown.Toggle id="dropdown-button-dark-example1" variant="">
                        <AccountCircleRoundedIcon/>
                    </Dropdown.Toggle>

                    <Dropdown.Menu variant="">
                        <Dropdown.Item href="#/action-1" active>
                            Action
                        </Dropdown.Item>
                        <Dropdown.Item href="#/action-2">Profile</Dropdown.Item>
                        <Dropdown.Item href="#/action-3">Saved</Dropdown.Item>
                        <Dropdown.Item href="#/action-4">Settings</Dropdown.Item>
                        <Dropdown.Divider />
                        <Dropdown.Item href="#/action-4">Log Out</Dropdown.Item>
                    </Dropdown.Menu>
                    </div>
                </Dropdown>





        </div>
    );


}
export default Nav;