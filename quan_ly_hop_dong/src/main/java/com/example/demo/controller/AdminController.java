package com.example.demo.controller;

import com.example.demo.entity.Login;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/admin-home")
public class AdminController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        Login acc = (session != null) ? (Login) session.getAttribute("account") : null;

        // Nếu chưa đăng nhập, chuyển về login
        if (acc == null || !"ADMIN".equalsIgnoreCase(acc.getRole())) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        req.setAttribute("account", acc);
        req.getRequestDispatcher("views/admin/home.jsp").forward(req, resp);
    }
}
