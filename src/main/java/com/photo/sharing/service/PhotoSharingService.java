package com.photo.sharing.service;

import com.photo.sharing.model.Photo;
import com.photo.sharing.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by AmitAgarwal on 5/2/19.
 */
@Service
public interface PhotoSharingService {
    List findAll();
    Photo save(Photo photo);
    List<Photo> findByUser(User user);
    Photo findByPhotoId(Long photoId);
}
