package com.springtutorials.blog.services.impl;

import com.springtutorials.blog.model.Post;
import com.springtutorials.blog.repositories.PostRepository;
import com.springtutorials.blog.services.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService implements IPostService {

    @Autowired
    PostRepository postRepository;

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Optional<Post> getPostById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public Post savePost(Post post) {
        post.setSlug(post.getTitle());
        return postRepository.save(post);
    }

    @Override
    public Post updatePost(Long id, Post newPost) {
        return postRepository.findById(id)
                .map(post -> {
                    post.setTitle(newPost.getTitle());
                    return postRepository.save(post);
                })
                .orElseGet(() -> {
                    newPost.setId(id);
                    return postRepository.save(newPost);
                });
    }

    @Override
    public void deletePostById(Long id) {
        postRepository.deleteById(id);
    }
}
