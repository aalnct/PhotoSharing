package com.photo.sharing.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by AmitAgarwal on 5/5/19.
 */
@Entity
public class Photo implements Serializable{

    public Photo(){}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long photoId;

    @Column
    private String photoName;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private String imageName;

    @Column
    @CreationTimestamp
    private Date createed;

    @ManyToOne
    @JsonBackReference
    private User user;

    @Column
    private int likes;

    @OneToMany(mappedBy = "photo", cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    private List<Comment> commentList;


    public Long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Long photoId) {
        this.photoId = photoId;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Date getCreateed() {
        return createed;
    }

    public void setCreateed(Date createed) {
        this.createed = createed;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
}
