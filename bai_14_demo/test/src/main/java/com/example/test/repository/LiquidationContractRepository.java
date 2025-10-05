package com.example.test.repository;



import com.example.test.entity.LiquidationContract;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LiquidationContractRepository implements ILiquidationContractRepository{
    private static final String SELECT_ALL =
            "SELECT l.liquidation_contract_id, l.liquidation_date, l.price, l.product_id " +
                    "FROM liquidation_contract l";
    private static final String INSERT = "insert into liquidation_contract " +
            "(liquidation_contract_id, liquidation_date, price, product_id) values(?, ?, ?, ?)";
    @Override
    public List<LiquidationContract> findAll() {
        List<LiquidationContract> liquidationContractList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int liquidationContractId = rs.getInt("liquidation_contract_id");
                LocalDate liquidationDate = rs.getDate("liquidation_date").toLocalDate();
                double price = rs.getDouble("price");
//                int productName = rs.getInt("product_id");
                LiquidationContract liquidationContract = new LiquidationContract(liquidationContractId, liquidationDate, price);
                liquidationContractList.add(liquidationContract);
            }
        } catch (SQLException e) {
            System.out.println("Error when getting products: " + e.getMessage());
        }
        return liquidationContractList;
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
