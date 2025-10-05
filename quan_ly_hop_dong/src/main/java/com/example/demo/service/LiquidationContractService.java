package com.example.demo.service;

import com.example.demo.dto.LiquidationContract;
import com.example.demo.repository.ILiquidationContractRepository;
import com.example.demo.repository.LiquidationContractRepository;


import java.util.List;

public class LiquidationContractService implements ILiquidationService {
    private final ILiquidationContractRepository liquidationContractRepository = new LiquidationContractRepository();
    @Override
    public List<LiquidationContract> findAll() {
        return liquidationContractRepository.findAll();
    }

    @Override
    public boolean add(LiquidationContract liquidationContract) {
        return liquidationContractRepository.add(liquidationContract);
    }

    @Override
    public boolean delete(int id) {
        return liquidationContractRepository.delete(id);
    }

    @Override
    public LiquidationContract findById(int id) {
        return liquidationContractRepository.findById(id);
    }

    @Override
    public List<LiquidationContract> search(String name, String categoryId) {
        return liquidationContractRepository.search(name, categoryId);
    }

    @Override
    public LiquidationContract findByIdProduct(int id) {
        return liquidationContractRepository.findByIdContract(id);
    }
}
