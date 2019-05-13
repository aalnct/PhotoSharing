package com.photo.sharing.controller;

import com.photo.sharing.model.Photo;
import com.photo.sharing.model.User;
import com.photo.sharing.service.PhotoSharingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * Created by AmitAgarwal on 5/11/19.
 */
@RestController
@RequestMapping("/rest")
public class PhotoResource {

    private String imageName;

    @Autowired
    private PhotoSharingService photoSharingService;

    @RequestMapping(value = "/photo/upload", method = RequestMethod.POST)
    public String uploadMethod(HttpServletResponse response, HttpServletRequest request){
        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
        Iterator<String> it = multipartHttpServletRequest.getFileNames();
        MultipartFile multipartFile = multipartHttpServletRequest.getFile(it.next());
        String fileName = multipartFile.getOriginalFilename();
        imageName = fileName;

        String path = new File("src/main/resources/static/images").getAbsolutePath() + File.separator + fileName;
        try{
            multipartFile.transferTo(new File(path));
            System.out.println(path);
        }catch(IOException io){
            io.printStackTrace();
        }

        return "Upload Success";

    }

    @RequestMapping(value = "/photo/add" , method = RequestMethod.POST)
    public Photo addPhoto(@RequestBody Photo photo){
        photo.setImageName(imageName);
        return photoSharingService.save(photo);
    }

    @RequestMapping(value = "/photo/user", method = RequestMethod.POST)
    public List<Photo> getPhotosByUser(@RequestBody User user){
        return photoSharingService.findByUser(user);
    }

    @RequestMapping(value = "/photo/photoId", method = RequestMethod.POST)
    public Photo getPhotoByPhotoId(@RequestBody Long photoId){
        return photoSharingService.findByPhotoId(photoId);
    }

    @RequestMapping(value = "/photo/update" , method = RequestMethod.POST)
    public void updatePhoto(@RequestBody Photo photo){
        Photo currentPhoto = photoSharingService.findByPhotoId(photo.getPhotoId());
        currentPhoto.setLikes(photo.getLikes());
        photoSharingService.save(currentPhoto);
    }


}
