package com.photo.sharing.service;

import com.photo.sharing.model.User;

import java.util.List;

/**
 * Created by AmitAgarwal on 5/6/19.
 */

public interface UserService {

    List<User> findAllUsers();
    User save(User user);
    User findByUserName(String userName);

}
