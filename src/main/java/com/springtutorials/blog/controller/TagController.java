package com.springtutorials.blog.controller;

import com.springtutorials.blog.model.Tag;
import com.springtutorials.blog.services.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TagController {

    @Autowired
    ITagService tagService;

    @GetMapping(value = "/tags")
    public ResponseEntity<List<Tag>> getAllTags() {
        return new ResponseEntity<>(tagService.getAllTags(), HttpStatus.OK);
    }

    @PostMapping(value = "/tags")
    public ResponseEntity<Tag> saveCategory(@RequestBody Tag nTag) {
        return new ResponseEntity<>(tagService.saveTag(nTag), HttpStatus.CREATED);
    }

    @GetMapping(value = "/tags/{id}")
    public ResponseEntity<Tag> getTagById(@PathVariable("id") Long id) throws Exception {
        return new ResponseEntity<>(tagService.getTagById(id).orElseThrow(() -> new Exception("post not found")), HttpStatus.OK);
    }

    @PutMapping(value = "/tags/{id}")
    public ResponseEntity<Tag> updateTagById(@RequestBody Tag tag, @PathVariable("id") Long id) {
        return new ResponseEntity<>(tagService.updateTag(id, tag), HttpStatus.OK);
    }

    @DeleteMapping(value = "/tags/{id}")
    public void deleteTagById(@PathVariable("id") Long id) {
        tagService.deleteTagById(id);
    }
}
