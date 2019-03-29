package com.thobho.repository;

import com.thobho.model.User;
import java.util.*;

import static java.util.Optional.empty;

public class UserDAO {

    private static UserDAO INSTANCE;

    private Map<Integer, User> userDatabase;

    private UserDAO() {
        this.userDatabase = new HashMap<>();
    }

    public static UserDAO getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new UserDAO();
            return INSTANCE;
        }
        return INSTANCE;
    }


    public User addUser2(User user){
        if(userDatabase.containsKey(user.getId())){
            return null;
        }
        userDatabase.put(user.getId(), user);
        return user;
    }

    public void addUser3(User userToSaveInDatabase){
        if(userDatabase.containsKey(userToSaveInDatabase.getId())){

        }else {
            userDatabase.put(userToSaveInDatabase.getId(), userToSaveInDatabase);
        }
    }

    public Optional<User> addUser(User user) {
        if (userDatabase.containsKey(user.getId())) {
            return Optional.empty();
        }
        userDatabase.put(user.getId(), user);
        return Optional.of(user);
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(userDatabase.values());
    }

    public Optional<User> getUserByLogin(String login){
        return userDatabase.values().stream()
                .filter(user -> user.getLogin().equals(login))
                .findAny();
    }

    public Optional<User> getUserById(int id) {
        return Optional.ofNullable(userDatabase.get(id));
    }
}
