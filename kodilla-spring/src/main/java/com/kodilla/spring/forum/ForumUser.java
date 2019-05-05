package com.kodilla.spring.forum;

import org.springframework.stereotype.Component;

@Component
public class ForumUser {
    private static final String USER_NAME = "John Smith";
    private String username;

    public ForumUser() {
        this.username = USER_NAME;
    }

    public String getUsername() {
        return username;
    }
}
