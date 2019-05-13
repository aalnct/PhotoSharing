package com.photo.sharing.controller;

import com.photo.sharing.model.Photo;
import com.photo.sharing.service.PhotoSharingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by AmitAgarwal on 5/2/19.
 */
@RestController
@RequestMapping(value = "/photo")
public class PhotoController {

    @Autowired
    private PhotoSharingService photoSharingService;

    @RequestMapping(value = "/getPhoto", method = RequestMethod.GET)
    public void getPhoto(){

    }

    @RequestMapping("/allPhotos")
    public List<Photo> getAllPhotos(){
        return photoSharingService.findAll();
    }



}
