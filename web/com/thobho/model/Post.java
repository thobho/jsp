package com.thobho.model;

import java.time.Instant;
import java.util.Objects;

public class Post {

    private static int ID_COUNTER = 0;

    private int id;
    private Instant date;
    private String text;
    private User user;

    public Post(String text, User user) {
        this.id = ID_COUNTER;
        this.date = Instant.now();
        this.text = text;
        this.user = user;
        ID_COUNTER++;
    }

    public int getId() {
        return id;
    }

    public Instant getDate() {
        return date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
