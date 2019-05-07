package com.photo.sharing.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by AmitAgarwal on 5/2/19.
 */
@RestController
@RequestMapping(value = "/")
public class PhotoController {

    @RequestMapping(value = "/getPhoto", method = RequestMethod.GET)
    public void getPhoto(){

    }

}
