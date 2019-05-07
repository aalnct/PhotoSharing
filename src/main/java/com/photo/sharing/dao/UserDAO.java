package com.photo.sharing.dao;

import com.photo.sharing.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by AmitAgarwal on 5/6/19.
 */
@Repository
public interface UserDAO extends CrudRepository<User,Long>{
    List<User> findAll();
    User findByUserName(String userName);
    User findByUserId(Long userId);
    User save(User user);
}
