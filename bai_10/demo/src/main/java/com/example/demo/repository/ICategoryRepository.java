package com.example.demo.repository;

import com.example.demo.entity.Category;

import java.util.List;

public interface ICategoryRepository {
    List<Category> findAll();
}
