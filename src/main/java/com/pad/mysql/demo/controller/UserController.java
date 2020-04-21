package com.pad.mysql.demo.controller;

import java.util.ArrayList;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.pad.mysql.demo.data.User;
import com.pad.mysql.demo.repo.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableHystrix
@RequestMapping("/demo")
public class UserController {

    @Autowired
    UserRepository userRepo;

    @GetMapping("/users")
    @HystrixCommand(fallbackMethod = "fallback_SingleUser", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000") })
    public @ResponseBody Iterable<User> getUser() {
        Iterable<User> users = userRepo.findAll();
        // try {
        //     Thread.sleep(3000);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
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


    private @ResponseBody Iterable<User> fallback_SingleUser() {
        User user1 = userRepo.findById(1).get();
        ArrayList<User> users = new ArrayList<User>();
        users.add(user1);
        return users;
    }

}