package com.photo.sharing.controller;

import com.photo.sharing.model.User;
import com.photo.sharing.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import java.util.Date;
import java.util.Map;

/**
 * Created by AmitAgarwal on 5/6/19.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@RequestBody Map<String,String> json) throws ServletException{
        if(json.get("username") == null || json.get("password") == null){
            throw new ServletException("Please Fill in username/password");
        }
        String userName = json.get("username");
        String password = json.get("password");

        User user = userService.findByUserName(userName);
        if(user == null){
            throw new ServletException("UserName not Found");
        }

        String pwd = user.getPassword();
        if(!password.equals(pwd)){
            throw new ServletException("Invalid Login, usename & password does not match");
        }


        return Jwts.builder().setSubject(userName).claim("roles","user").setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "secretkey").compact();
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public User registerUser(@RequestBody User user){
        return userService.save(user);
    }
}
