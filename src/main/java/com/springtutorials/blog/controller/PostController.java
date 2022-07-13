package com.springtutorials.blog.controller;

import com.springtutorials.blog.model.Post;
import com.springtutorials.blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping(value = "/posts")
    public ResponseEntity<List<Post>> getAllPosts() {
        return new ResponseEntity<>(postService.getAllPosts(), HttpStatus.OK);
    }

    @PostMapping(value = "/posts")
    public ResponseEntity<Post> savePost() {
        return new ResponseEntity<>(postService.savePost(), HttpStatus.CREATED);
    }

    @GetMapping(value = "/posts/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable("id") String id) {
        return new ResponseEntity<>(postService.getPostById(), HttpStatus.OK);
    }

    @PutMapping(value = "/posts/{id}")
    public ResponseEntity<Post> updatePostyById(@PathVariable("id") String id) {
        return new ResponseEntity<>(postService.updatePost(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/posts/{id}")
    public void deletePostById(@PathVariable("id") String id) {
        postService.deletePostById();
    }
}
