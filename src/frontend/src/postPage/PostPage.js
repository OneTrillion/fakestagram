import {useState} from "react";
import UploadIcon from '@mui/icons-material/Upload';
import {Container, Row, Col, Form, Button} from "react-bootstrap";

function PostPage() {
    //TODO Fixa så att urlen och texten sparas

    const [image, setImage] = useState('');
    const [description, setDescription] = useState('');
    const [loading, setLoading] = useState(false);
    const [uploaded, setUploaded] = useState(false);

    const handleDescriptionChange = (e) => {
        setDescription(e.target.value);
    }

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
        setUploaded(true);
    }

    //TODO fixa detta VVVV
    const makePost = () => {
        const currenDate = Date().toLocaleString();
        let postId = 0;

        fetch("/api/v1/post/make-post", {
            method: 'POST',
            body: {
                description: "asdasd",
                likedByUser: null,
                date: currenDate,
                img: image
            }
        })
            .then(res => res.json())
            .then(data => postId = data)

        fetch("/api/v1/users/post-id/{postId}", {
            method: 'PUT'
        })
    }

    return (
        <Container>
            <Row style={{backgroundColor: "gray", height: "50vh"}} className={"align-items-center"} >
                <Col>
                    { loading ? (
                        <h3>Loading...</h3>
                    ): (
                        !uploaded ? (
                            <UploadIcon style={{fontSize: "50vh" }} />
                        ): (
                            <img src={image} style={{width: '300px'}} alt={"asdasd"}/>
                        )
                    )}
                </Col>

            </Row>
            <Row>
                <input
                    type={"file"}
                    name={"file"}
                    placeholder={"Upload an image"}
                    onChange={uploadImage}
                />
            </Row>
            <Row>
               <Form>
                   <Form.Group className="mb-3" controlId="exampleForm.ControlTextarea1">
                       <Form.Control as="textarea" rows={3} placeholder={"Description..."} onChange={handleDescriptionChange} />
                   </Form.Group>
                   <Button variant="primary" type="submit" onClick={makePost}>POST</Button>
               </Form>
            </Row>

        </Container>
    )
}

export default PostPage;