import './App.css';
import {useState} from "react";

function App() {

    const [image, setImage] = useState('');
    const [loading, setLoading] = useState(false);
/*

    //Test för hur man kan använda vår api VVV
    const [users, setUsers] = useState([{}]);
    const fetchAllUsers = () => {
    getAllUsers()
      .then(res => res.json())
      .then(data => {
          console.log(data)
          setUsers(data);
      }).catch(err => {
          console.log(err);
    })
    }

    useEffect(() => {
        fetchAllUsers();
    }, [])
    
    const mapAllUsers = users.map(user =>
            <div key={user.id + user.name}>{user.name}</div>
        )
    //Test för hur vi kan använda vår api ^^^

*/
    //Lägger upp en ny bild på clouden och visar den på sidan
    const uploadImage = async e => {
        const files = e.target.files;
        const data = new FormData();
        data.append('file', files[0]);
        data.append('upload_preset', 'fakestagram')
        setLoading(true);
        const res = await fetch('https://api.cloudinary.com/v1_1/dg1uypbkk/image/upload',
            {
                method: 'POST',
                body: data
            })
        const file = await res.json();

        setImage(file.secure_url);
        setLoading(false);

    }
  return (
    <div className="App">
        <h1>Hello</h1>
        <h1>Upload image</h1>
        <input
            type={"file"}
            name={"file"}
            placeholder={"Upload an image"}
            onChange={uploadImage}
        />
        { loading ? (
            <h3>Loading...</h3>
        ): (
            <img src={image} style={{width: '300px'}} alt={"asdasd"}/>
        )}
    </div>
  );
}

export default App;
