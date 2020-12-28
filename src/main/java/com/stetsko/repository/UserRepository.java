package com.stetsko.repository;

import com.stetsko.entity.user.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    List<User> getAll();

    Optional<User> getById();

    User save(User user);
}
