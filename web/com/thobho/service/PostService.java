package com.thobho.service;

import com.thobho.model.Post;
import com.thobho.model.User;
import com.thobho.repository.PostDAO;
import com.thobho.repository.UserDAO;

import java.util.List;
import java.util.Optional;

public class PostService {

    private PostDAO postDAO;

    private UserDAO userDAO;

    public PostService() {
        this.postDAO = PostDAO.getInstance();
        this.userDAO = UserDAO.getInstance();
    }


    public void addNewPost(String postText, int userId){
        Optional<User> userById = userDAO.getUserById(userId);

        if(!userById.isPresent()){
            throw new IllegalStateException("Can not find user with id: "+userById);
        }

        postDAO.addPost(new Post(postText, userById.get()));

    }

    public List<Post> getAllPosts(){
        return postDAO.getAllPosts();
    }

}
