import "./Header.css"
import SearchIcon from '@mui/icons-material/Search';
import Nav from "./Nav";
function Header() {
    return (
        <div className="header">
            <h3 className="page-logo">Fakestagram</h3>

            <div className="searchBar">
                <div className="search-icon"><SearchIcon/></div>
                <input type="text"placeholder="Search"></input>

            </div>

            <div className="right-nav">
                <Nav/>
            </div>


        </div>
    );
}

export default Header;
