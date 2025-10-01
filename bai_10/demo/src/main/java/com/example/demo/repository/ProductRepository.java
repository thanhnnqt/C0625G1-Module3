package com.example.demo.repository;

import com.example.demo.entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private final static String SELECT_ALL = "select * from product";
    private final static String ADD_NEW =
            "insert into product(product_name, price, mo_ta, hang_san_xuat, so_luong, category_id) values (?,?,?,?,?,?)";
    private final static String SEARCH = "select p.*, c.category_name from product p join " +
            "category c on p.category_id = c.category_id where p.product_name like ? and c.category_id = ?";

    @Override
    public List<Product> findAll() {
        List<Product> productList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String tenSanPham = resultSet.getString("product_name");
                double giaSanPham = resultSet.getDouble("price");
                String moTaSanPham = resultSet.getString("mo_ta");
                String hangSanXuat = resultSet.getString("hang_san_xuat");
                int soLuong = resultSet.getInt("so_luong");
                int cId = resultSet.getInt("category_id");
                Product product = new Product(tenSanPham, giaSanPham, moTaSanPham, hangSanXuat, soLuong, cId);
                productList.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productList;
    }

    @Override
    public boolean add(Product product) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_NEW);
            preparedStatement.setString(1, product.getTenSanPham());
            preparedStatement.setDouble(2, product.getGiaSanPham());
            preparedStatement.setString(3, product.getMoTaSanPham());
            preparedStatement.setString(4, product.getHangSanXuat());
            preparedStatement.setInt(5, product.getSoLuong());
            preparedStatement.setInt(6, product.getcId());
            int row = preparedStatement.executeUpdate();
            return row == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
