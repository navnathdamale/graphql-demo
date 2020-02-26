package com.howtographql.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages user persistence
 */
public class UserRepository {

    private final List<User> users;

    public UserRepository() {
        users = new ArrayList<>();
        users.add(new User("user-01", "Test User-01", "test1@user.com", "Test1@123"));
        users.add(new User("user-02", "Test User-02", "test2@user.com", "Test2@123"));
    }

    public User findByEmail(String email) {
        return users.stream().filter(user -> user.getEmail().equals(email)).findFirst().orElse(null);
    }

    public User findById(String id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
    }

    public User saveUser(User user) {
        users.add(user);
        return user;

    }
}
