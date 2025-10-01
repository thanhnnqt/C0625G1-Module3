package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ICategoryService;
import com.example.demo.service.IProductService;
import com.example.demo.service.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductController", value = "/products")
public class ProductController extends HttpServlet {
    IProductService productService = new ProductService();
    ICategoryService categoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                // trả về form thêm mới
                req.setAttribute("categoryList", categoryService.findAll());
                req.getRequestDispatcher("views/product/add.jsp").forward(req, resp);
                break;
            case "delete":
                // xoá
                break;
            default:
                List<Product> productList = productService.findAll();
                req.setAttribute("productList", productList);
                req.getRequestDispatcher("views/product/list.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                String tenSanPham = req.getParameter("product_name");
                Double giaSanPham = Double.parseDouble(req.getParameter("price"));
                String moTaSanPham = req.getParameter("mo_ta");
                String hangSanXuat = req.getParameter("hang_san_xuat");
                int soLuong = Integer.parseInt(req.getParameter("so_luong"));
                int cId = Integer.parseInt(req.getParameter("category_id"));
                Product product = new Product(tenSanPham, giaSanPham, moTaSanPham, hangSanXuat, soLuong, cId);
                productService.add(product);
                List<Product> productList1 = productService.findAll();
                req.setAttribute("productList", productList1);
                req.getRequestDispatcher("views/product/list.jsp").forward(req, resp);
                break;
            case "delete":
                // xoá
                break;
            default:
                List<Product> productList = productService.findAll();
                req.setAttribute("productList", productList);
                req.getRequestDispatcher("views/product/list.jsp").forward(req, resp);
        }
    }
}
