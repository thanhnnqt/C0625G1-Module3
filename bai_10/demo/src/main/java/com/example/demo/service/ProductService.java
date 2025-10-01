package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.repository.IProductRepository;
import com.example.demo.repository.ProductRepository;

import java.util.List;

public class ProductService implements IProductService{
    private final IProductRepository productRepository = new ProductRepository();
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public boolean add(Product product) {
        return productRepository.add(product);
    }

}
