package com.example.test.service;



import com.example.test.entity.LiquidationContract;

import java.util.List;

public interface ILiquidationService {
    List<LiquidationContract> findAll();
    boolean add(LiquidationContract liquidationContract);
    boolean delete(int id);
    boolean update(LiquidationContract liquidationContract);
    LiquidationContract findById(int id);
    List<LiquidationContract> search(String name, String categoryId);
    LiquidationContract findByIdProduct(int id);
}
