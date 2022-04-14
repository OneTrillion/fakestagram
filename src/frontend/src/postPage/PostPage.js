import {useState} from "react";
import UploadIcon from '@mui/icons-material/Upload';
import {Container, Row, Col, Form, Button} from "react-bootstrap";

function PostPage() {
    //TODO Fixa så att urlen och texten sparas

    const [image, setImage] = useState('');
    const [loading, setLoading] = useState(false);
    const [uploaded, setUploaded] = useState(false);

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
            <Col>
                <Row style={{backgroundColor: "gray"}} className={"align-items-center"}>
                    <Col>
                        { loading ? (
                            <h3>Loading...</h3>
                        ): (
                            !uploaded ? (
                                <UploadIcon style={{fontSize: "500px" }} />
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
                           <Form.Label>Example textarea</Form.Label>
                           <Form.Control as="textarea" rows={3} />
                       </Form.Group>
                   </Form>
                </Row>
            </Col>

        </Container>
    )
}

export default PostPage;