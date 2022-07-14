package com.springtutorials.blog.controller;

import com.springtutorials.blog.model.Comment;
import com.springtutorials.blog.services.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    ICommentService commentService;

    @GetMapping(value = "/comments")
    public ResponseEntity<List<Comment>> getAllComments() {
        return new ResponseEntity<>(commentService.getAllComments(), HttpStatus.OK);
    }

    @PostMapping(value = "/comments")
    public ResponseEntity<Comment> saveComment(@RequestBody Comment nComment) {
        return new ResponseEntity<>(commentService.saveComment(nComment), HttpStatus.CREATED);
    }

    @GetMapping(value = "/comments/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable("id") Long id) throws Exception {
        return new ResponseEntity<>(commentService.getCommentById(id).orElseThrow(() -> new Exception("comment not found")), HttpStatus.OK);
    }

    @PutMapping(value = "/comments/{id}")
    public ResponseEntity<Comment> updateCommentById(@RequestBody Comment post, @PathVariable("id") Long id) {
        return new ResponseEntity<>(commentService.updateComment(id, post), HttpStatus.OK);
    }

    @DeleteMapping(value = "/comments/{id}")
    public void deleteCommentById(@PathVariable("id") Long id) {
        commentService.deleteCommentById(id);
    }
}
