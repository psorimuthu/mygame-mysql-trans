package com.pad.mysql.demo.controller;

import com.pad.mysql.demo.data.User;
import com.pad.mysql.demo.repo.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class UserController {
    
    @Autowired
    UserRepository userRepo;

    @GetMapping("/users")
    public @ResponseBody Iterable<User> getUser(){
        Iterable<User> users = userRepo.findAll();
        return users;
    }

    @PostMapping("/users/add")
    public @ResponseBody Iterable<User> addUser(@RequestBody User user2){
        User user=new User();
        user.setAge(3);
        user.setName("Yazh");
        userRepo.save(user);
        userRepo.save(user2);
        Iterable<User> users = userRepo.findAll();
        return users;
    }




}