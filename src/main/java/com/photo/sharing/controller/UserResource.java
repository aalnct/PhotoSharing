package com.photo.sharing.controller;

import com.photo.sharing.model.User;
import com.photo.sharing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by AmitAgarwal on 5/9/19.
 */
@RestController
@RequestMapping("/rest")
public class UserResource {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/users")
    public List<User> findAllUsers(){
        return userService.findAllUsers();
    }

    @RequestMapping(value = "/user/userName", method = RequestMethod.POST)
    public User findByUserName(@RequestBody String userName){
        System.out.println(userName);
        System.out.println(userService.findByUserName(userName));
        return userService.findByUserName(userName);
    }
    @RequestMapping(value = "/user/update" , method = RequestMethod.POST)
    public User updateUser(@RequestBody User user){
        return userService.save(user);
    }



}
