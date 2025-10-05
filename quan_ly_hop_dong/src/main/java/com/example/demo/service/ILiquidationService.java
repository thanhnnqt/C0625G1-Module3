package com.example.demo.service;

import com.example.demo.dto.LiquidationContract;
import java.util.List;

public interface ILiquidationService {
    List<LiquidationContract> findAll();
    boolean add(LiquidationContract liquidationContract);
    boolean delete(int id);
    LiquidationContract findById(int id);
    List<LiquidationContract> search(String name, String categoryId);
    LiquidationContract findByIdProduct(int id);
}
