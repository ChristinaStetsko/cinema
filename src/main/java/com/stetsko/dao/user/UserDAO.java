package com.stetsko.dao.user;

import com.stetsko.dao.DAO;
import com.stetsko.entity.user.User;

public interface UserDAO extends DAO<User> {
    User getByLogin(String login);
}
