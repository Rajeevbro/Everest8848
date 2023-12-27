package com.everest8848.Everest8848.service;

import com.everest8848.Everest8848.entity.User;
import com.everest8848.Everest8848.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public User postUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findUserByName(String userName) {
        System.out.println(userRepository.getUserByUserName(userName));
        System.out.println(userRepository.getUserByEmail("rajeevchapagain01@gmail.com"));
        return userRepository.getUserByUserName(userName);
    }
}
