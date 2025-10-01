package com.example.demo.repository;

import com.example.demo.dto.ProductDto;
import com.example.demo.entity.Product;

import java.util.List;

public interface IProductDtoRepository {
    List<ProductDto> findAll();
    boolean add(Product product);
    boolean delete(int id);
    boolean update(Product product);
    ProductDto findById(int id);
    List<ProductDto> search(String name, String categoryId);
    Product findByIdProduct(int id);
}
