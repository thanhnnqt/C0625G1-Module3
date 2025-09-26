package com.example.demo.controller;

import com.example.demo.entity.KhachHang;
import com.example.demo.service.IKhachHangService;
import com.example.demo.service.KhachHangService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "KhachHangController", value = "/khach-hang")

public class KhachHangController extends HttpServlet {
    IKhachHangService khachHangService = new KhachHangService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                // trả về form thêm mới
                req.getRequestDispatcher("views/khach_hang/add.jsp").forward(req, resp);
                break;
            case "delete":
                // xoá
                break;
            default:
                List<KhachHang> khachHangList = khachHangService.findAll();
                req.setAttribute("khachHangList", khachHangList);
                req.getRequestDispatcher("views/khach_hang/list.jsp").forward(req, resp);
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
                int id = Integer.parseInt(req.getParameter("id"));
                String name = req.getParameter("name");
                LocalDate birthDay = LocalDate.parse(req.getParameter("birthDay"));
                String address = req.getParameter("address");
                String anh = req.getParameter("anh");
                KhachHang khachHang = new KhachHang(id, name, birthDay, address, anh);
                khachHangService.add(khachHang);
                List<KhachHang> khachHangList1 = khachHangService.findAll();
                req.setAttribute("khachHangList", khachHangList1);
                req.getRequestDispatcher("views/khach_hang/list.jsp").forward(req, resp);
                break;
            case "delete":
                // xoá
                break;
            default:
                List<KhachHang> khachHangList = khachHangService.findAll();
                req.setAttribute("khachHangList", khachHangList);
                req.getRequestDispatcher("views/khach_hang/list.jsp").forward(req, resp);
        }
    }
}
