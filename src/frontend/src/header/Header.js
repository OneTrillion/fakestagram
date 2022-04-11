import "./Header.css"

import Nav from "./Nav";
function Header() {
    return (
        <div className="header">
            <h3 className="page-logo">Fakestagram</h3>

            <div className="searchBar">
                <input type="text" placeholder="Search"></input>
            </div>

            <div className="right-nav">
                <Nav/>
            </div>


        </div>
    );
}

export default Header;
