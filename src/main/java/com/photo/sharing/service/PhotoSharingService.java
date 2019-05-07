package com.photo.sharing.service;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by AmitAgarwal on 5/2/19.
 */
@Service
public interface PhotoSharingService {
    public List findAll();
}
