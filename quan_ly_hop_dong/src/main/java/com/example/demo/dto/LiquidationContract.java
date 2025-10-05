package com.example.demo.dto;

import java.time.LocalDate;

public class LiquidationContract {

    private int liquidationContractId;
    private LocalDate liquidationDate;
    private double liquidationPrice;
    private int customerId;
    private int employeeId;
    private int productId;

    public LiquidationContract() {
    }

    public LiquidationContract(int liquidationContractId, LocalDate liquidationDate, double liquidationPrice, int customerId, int employeeId, int productId) {
        this.liquidationContractId = liquidationContractId;
        this.liquidationDate = liquidationDate;
        this.liquidationPrice = liquidationPrice;
        this.customerId = customerId;
        this.employeeId = employeeId;
        this.productId = productId;
    }

    public LiquidationContract(int liquidationContractId, LocalDate liquidationDate, double liquidationPrice, int productId) {
        this.liquidationContractId = liquidationContractId;
        this.liquidationDate = liquidationDate;
        this.liquidationPrice = liquidationPrice;
        this.productId = productId;
    }
    public LiquidationContract(int liquidationContractId, LocalDate liquidationDate, double liquidationPrice) {
        this.liquidationContractId = liquidationContractId;
        this.liquidationDate = liquidationDate;
        this.liquidationPrice = liquidationPrice;
    }

    public int getLiquidationContractId() {
        return liquidationContractId;
    }

    public void setLiquidationContractId(int liquidationContractId) {
        this.liquidationContractId = liquidationContractId;
    }

    public LocalDate getLiquidationDate() {
        return liquidationDate;
    }

    public void setLiquidationDate(LocalDate liquidationDate) {
        this.liquidationDate = liquidationDate;
    }

    public double getLiquidationPrice() {
        return liquidationPrice;
    }

    public void setLiquidationPrice(double liquidationPrice) {
        this.liquidationPrice = liquidationPrice;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
