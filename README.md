# API Documentation

## AuthController

### Endpoints
| Method | Endpoint      | Request Body                         | Response                              | Description         |
|--------|---------------|---------------------------------------|----------------------------------------|---------------------|
| POST   | `/auth/login` | `{ "username": "string", "password": "string" }` | `{ "token": "string", "userDetails": { "userId": "int", "username": "string", "email": "string" } }` | Logs in a user      |
| POST   | `/auth/register` | `{ "username": "string", "password": "string", "email": "string" }` | `{ "userId": "int", "username": "string", "email": "string" }` | Registers a new user |

## CommentController

### Endpoints
| Method | Endpoint             | Request Params / Body                      | Response                                    | Description               |
|--------|----------------------|--------------------------------------------|---------------------------------------------|---------------------------|
| GET    | `/comment`           | `?userId=int&postId=int`                   | `[ { "commentId": "int", "userId": "int", "postId": "int", "text": "string" } ]` | Retrieves all comments (optionally filtered by user or post) |
| POST   | `/comment`           | `{ "userId": "int", "postId": "int", "text": "string" }` | `{ "commentId": "int", "userId": "int", "postId": "int", "text": "string" }` | Creates a new comment    |
| PUT    | `/comment/{commentId}` | `{ "text": "string" }`                    | `{ "commentId": "int", "userId": "int", "postId": "int", "text": "string" }` | Updates an existing comment |
| DELETE | `/comment/{commentId}` | N/A                                      | `{ "message": "string" }`                   | Deletes a comment          |

## LikeController

### Endpoints
| Method | Endpoint        | Request Params / Body                    | Response                              | Description          |
|--------|-----------------|------------------------------------------|----------------------------------------|----------------------|
| GET    | `/like`         | `?userId=int&postId=int`                 | `[ { "likeId": "int", "userId": "int", "postId": "int" } ]` | Retrieves all likes (optionally filtered by user or post) |
| POST   | `/like`         | `{ "userId": "int", "postId": "int" }`   | `{ "likeId": "int", "userId": "int", "postId": "int" }`   | Adds a new like      |
| DELETE | `/like/{likeId}` | N/A                                      | `{ "message": "string" }`              | Removes a like       |

## PostController

### Endpoints
| Method | Endpoint          | Request Params / Body                    | Response                                    | Description           |
|--------|-------------------|------------------------------------------|---------------------------------------------|-----------------------|
| GET    | `/post`           | `?userId=int`                            | `[ { "postId": "int", "userId": "int", "title": "string", "content": "string" } ]` | Retrieves all posts (optionally filtered by user) |
| POST   | `/post`           | `{ "userId": "int", "title": "string", "content": "string" }` | `{ "postId": "int", "userId": "int", "title": "string", "content": "string" }` | Creates a new post   |
| GET    | `/post/{postId}`  | N/A                                      | `{ "postId": "int", "userId": "int", "title": "string", "content": "string" }` | Retrieves a single post by ID |
| PUT    | `/post/{postId}`  | `{ "title": "string", "content": "string" }` | `{ "postId": "int", "userId": "int", "title": "string", "content": "string" }` | Updates an existing post |
| DELETE | `/post/{postId}`  | N/A                                      | `{ "message": "string" }`                   | Deletes a post        |

## UserController

### Endpoints
| Method | Endpoint          | Request Params / Body                    | Response                              | Description            |
|--------|-------------------|------------------------------------------|----------------------------------------|------------------------|
| GET    | `/User`           | N/A                                      | `[ { "userId": "int", "username": "string", "email": "string" } ]` | Retrieves all users    |
| POST   | `/User`           | `{ "username": "string", "email": "string", "password": "string" }` | `{ "userId": "int", "username": "string", "email": "string" }` | Creates a new user     |
| GET    | `/User/{userId}`  | N/A                                      | `{ "userId": "int", "username": "string", "email": "string" }` | Retrieves a user by ID |
| PUT    | `/User/{userId}`  | `{ "username": "string", "email": "string", "password": "string" }` | `{ "userId": "int", "username": "string", "email": "string" }` | Updates a user's details |
| DELETE | `/User/{userId}`  | N/A                                      | `{ "message": "string" }`              | Deletes a user         |






![java](https://github.com/user-attachments/assets/49128c5d-8c88-473f-8240-3e1a818c34b8)



