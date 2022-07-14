package com.springtutorials.blog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PostTag {
    @Id
    @GeneratedValue
    private Long id;

    private Long postId;
    private Long tagId;
}
