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

                    <HomeIcon/>
                    <SendIcon/>
                    <AddBoxIcon/>
                    <ExploreIcon/>
                    <FavoriteBorderIcon/>
                    <Dropdown.Toggle id="dropdown-button-dark-example1" variant="">
                        <AccountCircleRoundedIcon/>
                    </Dropdown.Toggle>

                    <Dropdown.Menu variant="">
                        <Dropdown.Item href="#/action-1" active>
                            Action
                        </Dropdown.Item>
                        <Dropdown.Item href="#/action-2">Another action</Dropdown.Item>
                        <Dropdown.Item href="#/action-3">Something else</Dropdown.Item>
                        <Dropdown.Divider />
                        <Dropdown.Item href="#/action-4">Separated link</Dropdown.Item>
                    </Dropdown.Menu>
                </Dropdown>




        </div>
    );


}
export default Nav;