package com.example.demo.service;

import com.example.demo.entity.Category;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ICategoryRepository;

import java.util.List;

public class CategoryService implements ICategoryService{
    private final ICategoryRepository categoryRepository = new CategoryRepository();
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
