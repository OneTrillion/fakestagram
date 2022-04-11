import "./Header.css"
import 'bootstrap/dist/css/bootstrap.min.css';
import {Dropdown} from "react-bootstrap";

function Header() {
    return (
        <div className="header">
           header

            <div className="searchBar">
               searchbar here
            </div>

            <div className="navi">
                <Dropdown>
                    <Dropdown.Toggle variant="primary" id="dropdown-basic">

                    </Dropdown.Toggle>

                    <Dropdown.Menu>
                        <Dropdown.Item href="#/action-1">Action</Dropdown.Item>
                        <Dropdown.Item href="#/action-2">Another action</Dropdown.Item>
                        <Dropdown.Item href="#/action-3">Something else</Dropdown.Item>
                    </Dropdown.Menu>
                </Dropdown>
            </div>


        </div>
    );
}

export default Header;
