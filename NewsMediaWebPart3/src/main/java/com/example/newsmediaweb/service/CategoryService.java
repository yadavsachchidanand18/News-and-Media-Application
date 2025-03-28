package com.example.newsmediaweb.service;

import com.example.newsmediaweb.daos.CategoryDao;
import com.example.newsmediaweb.model.Category;
import com.example.newsmediaweb.repository.CategoryRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements CategoryDao {
    private final CategoryRepo categoryRepo;

    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public void saveCategory(Category category) {
        categoryRepo.save(category);
    }

    @Override
    public List<Category> getCategories() {
        return categoryRepo.findAll();
    }

    @Override
    public void deleteCategory(Long id) {
       categoryRepo.deleteById(id);
    }
}
