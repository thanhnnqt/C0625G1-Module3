package com.example.demo.controller;

import com.example.demo.dto.ProductDto;
import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.service.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductController", value = "/products")
public class ProductController extends HttpServlet {
    IProductDtoService productService = new ProductDtoService();
    ICategoryService categoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(req, resp);
                break;
            case "edit":
                showEditForm(req, resp);
                break;
            case "delete":
                deleteProduct(req, resp);
                break;
            default:
                listProducts(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createProduct(req, resp);
                break;
            case "edit":
                updateProduct(req, resp);
                break;
            default:
                listProducts(req, resp);
                break;
        }
    }

    private void listProducts(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String searchName = req.getParameter("product_name");
        String searchCategory = req.getParameter("categoryId");

        List<ProductDto> products;
        if ((searchName != null && !searchName.isEmpty()) ||
                (searchCategory != null && !searchCategory.isEmpty())) {
            products = productService.search(searchName, searchCategory);
        } else {
            products = productService.findAll();
        }
        List<Category> categories = categoryService.findAll();
        req.setAttribute("products", products);
        req.setAttribute("categories", categories);
        req.setAttribute("selectedCategory", searchCategory);
        req.setAttribute("searchName", searchName);
        req.getRequestDispatcher("views/product/list.jsp").forward(req, resp);
    }

    private void showCreateForm(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Category> categories = categoryService.findAll();
        req.setAttribute("categories", categories);
        req.getRequestDispatcher("views/product/add.jsp").forward(req, resp);
    }

    private void createProduct(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        String tenSanPham = req.getParameter("product_name");
        double giaSanPham = Double.parseDouble(req.getParameter("price"));
        String moTaSanPham = req.getParameter("mo_ta");
        String hangSanXuat = req.getParameter("hang_san_xuat");
        int soLuong = Integer.parseInt(req.getParameter("so_luong"));
        int categoryId = Integer.parseInt(req.getParameter("category_id"));
        Product product = new Product(tenSanPham, giaSanPham, moTaSanPham, hangSanXuat, soLuong, categoryId);
        productService.add(product);
        resp.sendRedirect("/products");
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("product_id").trim());
        Product product = productService.findByIdProduct(id);
        List<Category> categories = categoryService.findAll();
        req.setAttribute("product", product);
        req.setAttribute("categories", categories);
        req.getRequestDispatcher("views/product/update.jsp").forward(req, resp);
    }

    private void updateProduct(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        try {
            int maSanPham = Integer.parseInt(req.getParameter("product_id"));
            String tenSanPham = req.getParameter("product_name");
            double giaSanPham = Double.parseDouble(req.getParameter("price"));
            String moTaSanPham = req.getParameter("mo_ta");
            String hangSanXuat = req.getParameter("hang_san_xuat");
            int soLuong = Integer.parseInt(req.getParameter("so_luong"));
            int categoryId = Integer.parseInt(req.getParameter("category_id"));
            Product product = new Product(maSanPham, tenSanPham, giaSanPham, moTaSanPham, hangSanXuat, soLuong, categoryId);

            boolean updated = productService.update(product);
            if (updated) {
                System.out.println("Update thành công: " + maSanPham);
            } else {
                System.out.println("Update thất bại: " + maSanPham);
            }

            resp.sendRedirect("/products");
        } catch (NumberFormatException e) {
            e.printStackTrace();
            resp.sendRedirect("/products");
        }
    }

    private void deleteProduct(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        int id = Integer.parseInt(req.getParameter("product_id").trim());
            productService.delete(id);
        resp.sendRedirect("/products");
    }
}
