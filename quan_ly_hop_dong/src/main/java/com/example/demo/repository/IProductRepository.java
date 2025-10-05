package com.example.demo.repository;

import com.example.demo.entity.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();

    boolean add(Product product);

}
