package com.thobho.service;

import com.thobho.model.User;
import com.thobho.repository.UserDAO;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public class UserService {

    private final UserDAO userDAO;

    public UserService() {
        this.userDAO = UserDAO.getInstance();
    }

    public Optional<User> createUser(String login, String password) {
        return userDAO.addUser(new User(login, password, Instant.now()));
    }

    public Optional<User> getUser(int id) {
        return userDAO.getUserById(id);
    }

    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    public Optional<User> getUserByLogin(String login){
        return userDAO.getUserByLogin(login);
    }
}
