package com.example.demo.repository;

import com.example.demo.dto.LiquidationContract;
import com.example.demo.entity.Product;

import java.util.List;

public interface ILiquidationContractRepository {
    List<LiquidationContract> findAll();
    boolean add(LiquidationContract liquidationContract);
    boolean delete(int id);
    LiquidationContract findById(int id);
    List<LiquidationContract> search(String name, String categoryId);
    LiquidationContract findByIdContract(int id);
}