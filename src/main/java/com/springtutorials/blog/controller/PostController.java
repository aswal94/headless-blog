package com.springtutorials.blog.controller;

import com.springtutorials.blog.model.Post;
import com.springtutorials.blog.services.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PostController {

    @Autowired
    IPostService postService;

    @GetMapping(value = "/posts")
    public ResponseEntity<List<Post>> getAllPosts() {
        return new ResponseEntity<>(postService.getAllPosts(), HttpStatus.OK);
    }

    @PostMapping(value = "/posts")
    public ResponseEntity<Post> savePost(@Valid @RequestBody Post nPost) {
        return new ResponseEntity<>(postService.savePost(nPost), HttpStatus.CREATED);
    }

    @GetMapping(value = "/posts/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable("id") Long id) throws Exception {
        return new ResponseEntity<>(postService.getPostById(id).orElseThrow(() -> new Exception("post not found")), HttpStatus.OK);
    }

    @PutMapping(value = "/posts/{id}")
    public ResponseEntity<Post> updatePostyById(@RequestBody Post post, @PathVariable("id") Long id) {
        return new ResponseEntity<>(postService.updatePost(id, post), HttpStatus.OK);
    }

    @DeleteMapping(value = "/posts/{id}")
    public void deletePostById(@PathVariable("id") Long id) {
        postService.deletePostById(id);
    }
}
