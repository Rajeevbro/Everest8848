package com.everest8848.Everest8848.service;

import com.everest8848.Everest8848.entity.User;

public interface UserService {
    User postUser(User user);

    User findUserByName(String userName);
}
