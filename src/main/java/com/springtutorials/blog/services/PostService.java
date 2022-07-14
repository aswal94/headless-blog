package com.springtutorials.blog.services;

import com.springtutorials.blog.model.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {

    List<Post> getAllPosts();

    Optional<Post> getPostById(Long id);

    Post savePost(Post post);

    Post updatePost(Long id, Post post);

    void deletePostById(Long id);

}
