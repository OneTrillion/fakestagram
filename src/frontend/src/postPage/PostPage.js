import {useState} from "react";
import UploadIcon from '@mui/icons-material/Upload';
import {Container, Row, Col, Form, Button} from "react-bootstrap";
import {createPost, uploadImageCloud} from "../client";

function PostPage() {
    //TODO Fixa så att urlen och texten sparas

    const [image, setImage] = useState('');
    const [description, setDescription] = useState('');
    const [loading, setLoading] = useState(false);
    const [uploaded, setUploaded] = useState(false);

    const handleDescriptionChange = (e) => {
        setDescription(e.target.value);
        console.log(description);
        console.log(typeof description);
    }
/*
    const uploadImage2 = async e => {
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
 */
    const uploadImage = (e) => {
        const files = e.target.files;
        const payload = new FormData();
        payload.append('file', files[0]);
        payload.append('upload_preset', 'fakestagram')
        setLoading(true);

        uploadImageCloud(payload)
            .then(res => res.json())
            .then(file => setImage(file.secure_url))
            .catch(err => console.log(err.response))

        setLoading(false);
        setUploaded(true);
    }


    //TODO fixa med userid, testa med formdata??
    const makePost = () => {
        const currenDate = Date().toLocaleString();

        console.log(description + typeof description);
        console.log(currenDate + typeof currenDate);
        console.log(image + typeof image);

        /*
        const payload = new FormData();

        payload.append('userId', '4')
        payload.append('description', 'testdescription')
        payload.append('likedByUser', null)
        payload.append('date', '1a januari')
        payload.append('img', image)
*/

        createPost()
            .catch(err => console.log(err.response))
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
                </Form>
                <Button variant="primary" type="submit" onClick={makePost}>POST</Button>
            </Row>

        </Container>
    )
}

export default PostPage;