package com.springtutorials.blog.services;

import com.springtutorials.blog.model.Post;

import java.util.List;

public interface PostService {

    List<Post> getAllPosts();

    Post getPostById();

    Post savePost();

    Post updatePost();

    void deletePostById();

}
