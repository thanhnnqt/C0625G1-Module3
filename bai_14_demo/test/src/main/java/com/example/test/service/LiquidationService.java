package com.example.test.service;

import com.example.test.entity.LiquidationContract;
import com.example.test.repository.ILiquidationContractRepository;
import com.example.test.repository.LiquidationContractRepository;

import java.util.List;

public class LiquidationService implements ILiquidationService{
    private final ILiquidationContractRepository liquidationContractRepository = new LiquidationContractRepository();
    @Override
    public List<LiquidationContract> findAll() {
        return liquidationContractRepository.findAll();
    }

    @Override
    public boolean add(LiquidationContract liquidationContract) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean update(LiquidationContract liquidationContract) {
        return false;
    }

    @Override
    public LiquidationContract findById(int id) {
        return null;
    }

    @Override
    public List<LiquidationContract> search(String name, String categoryId) {
        return List.of();
    }

    @Override
    public LiquidationContract findByIdProduct(int id) {
        return null;
    }
}
