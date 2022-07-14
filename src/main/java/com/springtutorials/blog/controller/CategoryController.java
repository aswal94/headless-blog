package com.springtutorials.blog.controller;

import com.springtutorials.blog.model.Category;
import com.springtutorials.blog.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    ICategoryService categoryService;

    @GetMapping(value = "/category")
    public ResponseEntity<List<Category>> getAllCategorys() {
        return new ResponseEntity<>(categoryService.getAllCategories(), HttpStatus.OK);
    }

    @PostMapping(value = "/category")
    public ResponseEntity<Category> saveCategory(@RequestBody Category nCategory) {
        return new ResponseEntity<>(categoryService.saveCategory(nCategory), HttpStatus.CREATED);
    }

    @GetMapping(value = "/category/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("id") Long id) throws Exception {
        return new ResponseEntity<>(categoryService.getCategoryById(id).orElseThrow(() -> new Exception("post not found")), HttpStatus.OK);
    }

    @PutMapping(value = "/category/{id}")
    public ResponseEntity<Category> updateCategoryyById(@RequestBody Category post, @PathVariable("id") Long id) {
        return new ResponseEntity<>(categoryService.updateCategory(id, post), HttpStatus.OK);
    }

    @DeleteMapping(value = "/category/{id}")
    public void deleteCategoryById(@PathVariable("id") Long id) {
        categoryService.deleteCategoryById(id);
    }
}
