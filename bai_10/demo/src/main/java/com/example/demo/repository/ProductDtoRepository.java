package com.example.demo.repository;

import com.example.demo.dto.ProductDto;
import com.example.demo.entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDtoRepository implements IProductDtoRepository {
    private static final String SELECT_ALL_PRODUCT = "SELECT p.id, p.name, p.price, p.quantity, p.description, c.name AS categoryName " + "FROM product p " + "JOIN category c ON p.category_id = c.id;";
    private static final String INSERT_PRODUCT = "INSERT INTO product (name, price, quantity, description, category_id) VALUES (?, ?, ?, ?, ?)";
    private static final String DELETE_SQL = "DELETE FROM users WHERE id = ?";
    private static final String UPDATE_SQL = "UPDATE users SET name = ?, email = ?, country = ? WHERE id = ?";

    @Override
    public List<ProductDto> findAll() {
        List<ProductDto> productList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("product_id");
                String name = rs.getString("product_name");
                double price = rs.getDouble("price");
                String moTaSanPham = rs.getString("mo_ta");
                String hangSanXuat = rs.getString("hang_san_xuat");
                int soLuong = rs.getInt("so_luong");
                String categoryName = rs.getString("category_name");
                ProductDto product = new ProductDto(id, name, price, moTaSanPham, hangSanXuat, soLuong, categoryName);
                productList.add(product);
            }
        } catch (SQLException e) {
            System.out.println("Error when getting products: " + e.getMessage());
        }
        return productList;
    }

    @Override
    public boolean add(Product product) {
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement ps = connection.prepareStatement(INSERT_PRODUCT)) {
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
    public boolean delete(int maSanPham) {
        String sql = "DELETE FROM product WHERE product_id = ?";
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, maSanPham);
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(Product product) {
        final String SQL = "UPDATE product SET product_name = ?, price = ?, mo_ta = ?, hang_san_xuat = ?, so_luong =?, category_id = ? WHERE category_id = ?";
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
    public ProductDto findById(int id) {
        return null;
    }

    public List<ProductDto> search(String searchName, String categoryId) {
        List<ProductDto> list = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT p.product_id, p.product_name, p.price, p.mo_ta, p.hang_san_xuat, p.so_luong, c.category_name AS categoryName "
                + "FROM product p JOIN category c ON p.category_id = c.category_id WHERE 1=1 ");
        if (searchName != null && !searchName.isEmpty()) {
            sql.append(" and p.name like ?");
        }
        if (categoryId != null && !categoryId.isEmpty()) {
            sql.append(" and c.id = ?");
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
                list.add(new ProductDto(rs.getInt("product_id"),
                        rs.getString("product_name"),
                        rs.getDouble("price"),
                        rs.getString("mo_ta"),
                        rs.getString("hang_san_xuat"),
                        rs.getInt("so_luong"),
                        rs.getString("caterogy_name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Product findByIdProduct(int id) {
        String sql = "SELECT product_id, product_name, price, mo_ta, hang_san_xuat, so_luong, category_id FROM product WHERE category_id = ?";
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
