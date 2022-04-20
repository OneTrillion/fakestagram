import fetch from 'unfetch';

const checkStatus = response => {
    if (response.ok) {
        return response;
    }
    //convert non-2xx HTTP responses into errors
    const error = new Error(response.statusText);
    error.response = response;
    return Promise.reject(error);
}

export const getAllUsers = () =>
    fetch(`api/v1/users/all`)
        .then(checkStatus);


export const createPost = (desc, currDate, img) =>
    fetch("/api/v1/post/make-post", {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            userId: null,
            description: desc,
            likedByUser: null,
            date: currDate,
            img: img
        })
    }).then(checkStatus);

export const uploadImageCloud = (payload) =>
    fetch('https://api.cloudinary.com/v1_1/dg1uypbkk/image/upload', {
        method: 'POST',
        body: payload
    }).then(checkStatus);

export const getAllPosts = () =>
    fetch("api/v1/post/view-posts")
        .then(checkStatus)


export const getCurrentUserInfo = () =>
    fetch("api/v1/users/current-user")
        .then(checkStatus)

export const getUserInfoByUsername = (username) =>
    fetch(`api/v1/users/user-info/${username}`)
        .then(checkStatus)


export const getPostsByUserId = (id) =>
    fetch(`/api/v1/post/user-posts/${id}`)
        .then(checkStatus)


export const updatePost = (newDesc, id) =>
    fetch(`/api/v1/post/update/${id}`, {
        method: 'PUT',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            userId: id,
            description: newDesc,

        })
    }).then(checkStatus);

export const updateBio = (newBio) =>
    fetch("/api/v1/user/change-bio", {
        method: 'PUT',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            description: newBio,

        })
    }).then(checkStatus);