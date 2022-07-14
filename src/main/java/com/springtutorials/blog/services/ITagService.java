package com.springtutorials.blog.services;

import com.springtutorials.blog.model.Category;

import java.util.List;
import java.util.Optional;

public interface ITagService {
    List<Category> getAllCategories();

    Optional<Category> getCategoryById(Long id);

    Category saveCategory(Category post);

    Category updateCategory(Long id, Category post);

    void deleteCategoryById(Long id);
}
