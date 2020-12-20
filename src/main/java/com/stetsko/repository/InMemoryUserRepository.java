package com.stetsko.repository;

import com.stetsko.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryUserRepository implements UserRepository {

    public static InMemoryUserRepository inMemoryUserRepository = new InMemoryUserRepository();

    public InMemoryUserRepository() {
    }

    private static final List<User> users = new ArrayList<>();

    private AtomicInteger idGenerator = new AtomicInteger(1);


    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public Optional<User> getById() {
        return Optional.empty();
    }

    @Override
    public User save(User user) {
        user.setId(idGenerator.getAndIncrement());
        users.add(user);
        return user;
    }
}