import "./EditProfile.css";
import {useState} from "react";
import {Button, Form} from "react-bootstrap";
import {createPost, updateBio} from "../../client";
import Header from "../header/Header";

function EditProfile() {

    const [newBio, setNewBio] = useState('');

    const changeBio = (e) => {
        setNewBio(e.target.value);
    }

    const ourNewBio = () => {
        updateBio(newBio)
            .catch(err => console.log(err.response))
    }

    const onSubmitEvent = (e) => {
        e.preventDefault();
         ourNewBio()
        console.log("Hello " + newBio + "!");
    };

    return(
        <div className="Edit-Profile">
            <Header/>

            <form onSubmit={onSubmitEvent}>
            <input
            type="text"
            name="yourname"
            placeholder="write new bio"
            onChange={changeBio}
            />
            <button type="submit">Save</button>
            </form>

        </div>

    );

}
export default EditProfile;

