package com.photo.sharing.dao;

import com.photo.sharing.model.Photo;
import com.photo.sharing.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by AmitAgarwal on 5/2/19.
 */
@Repository
public interface PhotoSharingDao extends CrudRepository<Photo, Long>{
    List<Photo> findByUser(User user);
    Photo findByPhotoId(Long photoId);
}
