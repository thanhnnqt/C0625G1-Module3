package com.example.demo.repository;

import com.example.demo.dto.LiquidationContract;
import com.example.demo.entity.Product;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LiquidationContractRepository implements ILiquidationContractRepository {
    private static final String SELECT_ALL = "select l.liquidation_contract_id, l.liquidation_date, l.price, p.product_name\n" +
            "from liquidation_contract l join product p on p.product_id = l.product_id";
    private static final String INSERT = "insert into liquidation_contract " +
            "(liquidation_date, price, customer_id, employee_id, product_id) values(?, ?, ?, ?, ?)";
    private static final String DELETE = "delete from liquidation_contract where liquidation_contract_id = ?";

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
                String productName = rs.getString("product_name");
                LiquidationContract liquidationContract = new LiquidationContract(liquidationContractId, liquidationDate, price, productName);
                liquidationContractList.add(liquidationContract);
            }
        } catch (SQLException e) {
            System.out.println("Error when getting products: " + e.getMessage());
        }
        return liquidationContractList;
    }

    @Override
    public boolean add(LiquidationContract liquidationContract) {
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement ps = connection.prepareStatement(INSERT)) {
            ps.setDate(1, Date.valueOf(liquidationContract.getLiquidationDate()));
            ps.setDouble(2, liquidationContract.getLiquidationPrice());
            ps.setInt(3, liquidationContract.getCustomerId());
            ps.setInt(4, liquidationContract.getEmployeeId());
            ps.setInt(5, liquidationContract.getProductId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement ps = connection.prepareStatement(DELETE)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(Product product) {
        final String SQL = "UPDATE product SET product_name = ?, price = ?, mo_ta = ?, hang_san_xuat = ?, so_luong = ?, category_id = ? WHERE product_id = ?";
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement ps = connection.prepareStatement(SQL)) {

            ps.setString(1, product.getTenSanPham());
            ps.setDouble(2, product.getGiaSanPham());
            ps.setString(3, product.getMoTaSanPham());
            ps.setString(4, product.getHangSanXuat());
            ps.setInt(5, product.getSoLuong());
            ps.setInt(6, product.getcId());
            ps.setInt(7, product.getMaSanPham());

            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public LiquidationContract findById(int id) {
        return null;
    }

    public List<LiquidationContract> search(String searchName, String productId) {
        List<LiquidationContract> list = new ArrayList<>();
        StringBuilder sql = new StringBuilder("select l.liquidation_contract_id, l.liquidation_date," +
                " l.price, p.product_name from liquidation_contract l join product p on p.product_id = l.product_id where 1 = 1");

        if (searchName != null && !searchName.isEmpty()) {
            sql.append(" and p.liquidation_contract_id = ?");
        }
        if (productId != null && !productId.isEmpty()) {
            sql.append(" and c.product_name like ?");
        }
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement ps = connection.prepareStatement(sql.toString())) {
            int index = 1;
            if (searchName != null && !searchName.isEmpty()) {
                ps.setString(index++, searchName);
            }
            if (productId != null && !productId.isEmpty()) {
                ps.setInt(index++, Integer.parseInt(productId));
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new LiquidationContract(
                        rs.getInt("liquidation_contract_id"),
                        rs.getDate("product_name").toLocalDate(),
                        rs.getDouble("price"),
                        rs.getString("product_name")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Product findByIdContract(int id) {
        String sql = "SELECT product_id, product_name, price, mo_ta, hang_san_xuat, so_luong, category_id FROM product WHERE product_id = ?";
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Product(
                        rs.getInt("product_id"),
                        rs.getString("product_name"),
                        rs.getDouble("price"),
                        rs.getString("mo_ta"),
                        rs.getString("hang_san_xuat"),
                        rs.getInt("so_luong"),
                        rs.getInt("caterogy_id")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
