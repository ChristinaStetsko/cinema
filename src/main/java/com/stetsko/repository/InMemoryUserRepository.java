package com.stetsko.repository;

import com.stetsko.entity.User;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryUserRepository {

    public static InMemoryUserRepository inMemoryUserRepository = new InMemoryUserRepository();

    private ArrayList<User> users = new ArrayList<>();

    private AtomicInteger idGenerator = new AtomicInteger(1);

    public User saveUser(User user) {
        user.setId(idGenerator.getAndIncrement());
        users.add(user);
        return user;
    }

    public ArrayList<User> getAllUsers() {
        return users;
    }
}