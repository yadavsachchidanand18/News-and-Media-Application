package com.example.newsmediaweb.controller;

import com.example.newsmediaweb.model.Category;
import com.example.newsmediaweb.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @PostMapping("/categories")
    public void createCategory(@RequestBody Category category) {
        categoryService.saveCategory(category);
    }
    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return categoryService.getCategories();
    }

    @DeleteMapping("/categories/{id}")
    public void deleteCategory(@PathVariable Long id) { categoryService.deleteCategory(id); }


}
