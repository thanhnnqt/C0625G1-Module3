package com.example.demo.service;

import com.example.demo.dto.ProductDto;
import com.example.demo.entity.Product;
import com.example.demo.repository.IProductDtoRepository;
import com.example.demo.repository.ProductDtoRepository;

import java.util.List;

public class ProductDtoService implements IProductDtoService{
    private final IProductDtoRepository productDtoRepository = new ProductDtoRepository();
    @Override
    public List<ProductDto> findAll() {
        return productDtoRepository.findAll();
    }

    @Override
    public boolean add(Product product) {
        return productDtoRepository.add(product);
    }

    @Override
    public boolean delete(int id) {
        return productDtoRepository.delete(id);
    }

    @Override
    public boolean update(Product product) {
        return productDtoRepository.update(product);
    }

    @Override
    public ProductDto findById(int id) {
        return productDtoRepository.findById(id);
    }

    @Override
    public List<ProductDto> search(String name, String categoryId) {
        return productDtoRepository.search(name, categoryId);
    }

    @Override
    public Product findByIdProduct(int id) {
        return productDtoRepository.findByIdProduct(id);
    }
}
