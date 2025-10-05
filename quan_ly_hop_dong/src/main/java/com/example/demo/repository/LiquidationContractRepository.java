package com.example.demo.repository;

import com.example.demo.dto.LiquidationContract;
import com.example.demo.entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LiquidationContractRepository implements ILiquidationContractRepository {
    private static final String SELECT_ALL = "select l.liquidation_contract_id, l.liquidation_date, l.price, p.product_id " +
            "from liquidation_contract l join product p on p.product_id = l.product_id order by p.product_id asc";
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
                int productId = rs.getInt("product_id");
                LiquidationContract liquidationContract = new LiquidationContract(liquidationContractId, liquidationDate, price, productId);
                liquidationContractList.add(liquidationContract);
            }
        } catch (SQLException e) {
            System.out.println("Error when getting products: " + e.getMessage());
        }
        return liquidationContractList;
    }

    @Override
    public boolean add(Product product) {
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement ps = connection.prepareStatement(INSERT)) {
            ps.setString(1, product.getTenSanPham());
            ps.setDouble(2, product.getGiaSanPham());
            ps.setString(3, product.getMoTaSanPham());
            ps.setString(4, product.getHangSanXuat());
            ps.setInt(5, product.getSoLuong());
            ps.setInt(6, product.getcId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM product WHERE product_id = ?";
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement ps = connection.prepareStatement(sql)) {
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

    public List<LiquidationContract> search(String searchName, String categoryId) {
        List<LiquidationContract> list = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT p.product_id, p.product_name, p.price, p.mo_ta, p.hang_san_xuat, p.so_luong, c.category_name "
                + "FROM product p JOIN category c ON p.category_id = c.category_id WHERE 1=1");
        if (searchName != null && !searchName.isEmpty()) {
            sql.append(" and p.product_name like ?");
        }
        if (categoryId != null && !categoryId.isEmpty()) {
            sql.append(" and c.category_id = ?");
        }
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement ps = connection.prepareStatement(sql.toString())) {
            int index = 1;
            if (searchName != null && !searchName.isEmpty()) {
                ps.setString(index++, "%" + searchName + "%");
            }
            if (categoryId != null && !categoryId.isEmpty()) {
                ps.setInt(index++, Integer.parseInt(categoryId));
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new LiquidationContract(
                        rs.getInt("liquidation_contract_id"),
                        rs.getDate("product_name").toLocalDate(),
                        rs.getDouble("price"),
                        rs.getInt("product_name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Product findByIdProduct(int id) {
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
