package com.example.demo.service;

import com.example.demo.dto.LiquidationContract;
import com.example.demo.entity.Product;
import com.example.demo.repository.ILiquidationContractRepository;
import com.example.demo.repository.LiquidationContractRepository;


import java.util.List;

public class LiquidationContractService implements ILiquidationService {
    private final ILiquidationContractRepository productDtoRepository = new LiquidationContractRepository();
    @Override
    public List<LiquidationContract> findAll() {
        return productDtoRepository.findAll();
    }

    @Override
    public boolean add(LiquidationContract liquidationContract) {
        return productDtoRepository.add(liquidationContract);
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
    public LiquidationContract findById(int id) {
        return productDtoRepository.findById(id);
    }

    @Override
    public List<LiquidationContract> search(String name, String categoryId) {
        return productDtoRepository.search(name, categoryId);
    }

    @Override
    public Product findByIdProduct(int id) {
        return productDtoRepository.findByIdContract(id);
    }
}
