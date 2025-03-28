package com.example.newsmediaweb.daos;

import com.example.newsmediaweb.model.Category;

import java.util.List;

public interface CategoryDao {
    void saveCategory(Category category);
    List<Category> getCategories();
    void deleteCategory(Long id);
}
