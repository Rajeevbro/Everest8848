package com.everest8848.Everest8848.controller;

import com.everest8848.Everest8848.entity.User;
import com.everest8848.Everest8848.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping
    public User postUser(@RequestBody User user){
        return userService.postUser(user);

    }
    @GetMapping
    public User findUserByName(@RequestParam("userName")String userName){
        System.out.println(userName);
        return userService.findUserByName(userName);
    }
}
