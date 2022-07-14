package com.springtutorials.blog.services.impl;

import com.springtutorials.blog.model.Category;
import com.springtutorials.blog.repositories.CategoryRepository;
import com.springtutorials.blog.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Long id, Category newCategory) {
        return categoryRepository.findById(id)
                .map(category -> {
                    category.setName(newCategory.getName());
                    category.setSlug(newCategory.getName());
                    return categoryRepository.save(category);
                })
                .orElseGet(() -> {
                    newCategory.setId(id);
                    return categoryRepository.save(newCategory);
                });
    }

    @Override
    public void deleteCategoryById(Long id) {
        categoryRepository.deleteById(id);
    }
}
