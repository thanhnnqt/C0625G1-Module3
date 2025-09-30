package com.example.demo.repository;

import com.example.demo.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private static List<Product> productList = new ArrayList<>();

    {
        productList.add(new Product(1, "Samsung S25", 20, "Smart phone", "Samsung", 5));
        productList.add(new Product(2, "Samsung S24", 19, "Smart phone", "Samsung", 10));
        productList.add(new Product(3, "Iphone 13", 18, "Smart phone", "Apple", 8));
        productList.add(new Product(4, "Samsung S22", 17, "Smart phone", "Samsung", 2));
        productList.add(new Product(5, "Iphone 15", 16, "Smart phone", "Apple", 6));
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public boolean add(Product product) {
        return productList.add(product);
    }
}
