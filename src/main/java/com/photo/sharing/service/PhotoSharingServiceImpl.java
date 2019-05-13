package com.photo.sharing.service;

import com.photo.sharing.dao.PhotoSharingDao;
import com.photo.sharing.model.Photo;
import com.photo.sharing.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by AmitAgarwal on 5/2/19.
 */
@Service
public class PhotoSharingServiceImpl implements PhotoSharingService {

    @Autowired
    private PhotoSharingDao photoSharingDao;

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public Photo save(Photo photo) {
        return photoSharingDao.save(photo);
    }

    @Override
    public List<Photo> findByUser(User user) {
        return photoSharingDao.findByUser(user);
    }

    @Override
    public Photo findByPhotoId(Long photoId) {
        return photoSharingDao.findByPhotoId(photoId);
    }
}
