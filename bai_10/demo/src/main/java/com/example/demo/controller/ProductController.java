package com.example.demo.controller;

import com.example.demo.entity.Product;
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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                // trả về form thêm mới
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
                // trả về form thêm mới
                int maSanPham = Integer.parseInt(req.getParameter("maSanPham"));
                String tenSanPham = req.getParameter("tenSanPham");
                Double giaSanPham = Double.parseDouble(req.getParameter("giaSanPham"));
                String moTaSanPham = req.getParameter("moTaSanPham");
                String hangSanXuat = req.getParameter("hangSanXuat");
                int soLuong = Integer.parseInt(req.getParameter("soLuong"));
                Product product = new Product(maSanPham, tenSanPham, giaSanPham, moTaSanPham, hangSanXuat, soLuong);
                productService.add(product);
                List<Product> productList1 = productService.findAll();
                req.setAttribute("productList1", productList1);
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
