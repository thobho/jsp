package com.thobho.repository;

import com.thobho.model.User;
import java.util.*;

import static java.util.Optional.empty;

public class UserDAO {

    private static UserDAO INSTANCE;

    public static UserDAO getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new UserDAO();
            return INSTANCE;
        }
        return INSTANCE;
    }

    private Map<Integer, User> userDatabase;

    private UserDAO() {
        this.userDatabase = new HashMap<>();
    }

    public synchronized Optional<User> addUser(User user) {
        if (userDatabase.containsKey(user.getId())) {
            return empty();
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
