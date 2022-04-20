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
import {Link} from "react-router-dom";

function Nav() {

   // const history = useNavigate();
    return(
        <div className="nav">
                <Dropdown>

                    <div className="dropdown-icons-cont">

                        <div className="home-icon"><Link to="/"><HomeIcon/></Link></div>
                        <div className="send-icon"> <Link to="/friend-page"><SendIcon/></Link></div>
                        <div className="add-box-icon"><Link to="/post-page"><AddBoxIcon/></Link></div>
                        <div className="explore-icon"><Link to="/"><ExploreIcon/></Link></div>
                        <div className="favorite-border-icon"><Link to="/"><FavoriteBorderIcon/></Link></div>

                    <Dropdown.Toggle id="example1" variant="">
                        <AccountCircleRoundedIcon/>
                    </Dropdown.Toggle>

                    <Dropdown.Menu variant="">
                        <Dropdown.Item>
                            <Link to={"/my-page"}> <PermIdentityRoundedIcon/> Profile </Link>
                        </Dropdown.Item>
                        <Dropdown.Item>
                            <Link to={"/"}> <BookmarkBorderIcon/> Saved </Link>
                        </Dropdown.Item>
                        <Dropdown.Item>
                            <Link to={"/my-page"}> <SettingsIcon/> Settings </Link>
                        </Dropdown.Item>
                        <Dropdown.Divider />
                        <Dropdown.Item>
                            <Link to={"/logout"}> Log Out</Link>
                        </Dropdown.Item>
                    </Dropdown.Menu>
                    </div>
                </Dropdown>





        </div>
    );


}
export default Nav;