package com.springtutorials.blog.services;

import com.springtutorials.blog.model.Category;
import com.springtutorials.blog.model.Post;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> getAllCategories();

    Optional<Category> getCategoryById(Long id);

    Category saveCategory(Category post);

    Category updateCategory(Long id, Category post);

    void deleteCategoryById(Long id);
}
