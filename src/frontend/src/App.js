import './App.css';

function App() {

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

  return (
    <div className="App">
        <h1>Hello</h1>
    </div>
  );
}

export default App;
