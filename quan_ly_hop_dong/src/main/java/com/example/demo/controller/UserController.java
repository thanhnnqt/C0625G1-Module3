package com.example.demo.controller;

import com.example.demo.entity.Login;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/customer-home")
public class UserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        Login acc = (session != null) ? (Login) session.getAttribute("account") : null;

        if (acc == null || !"USER".equalsIgnoreCase(acc.getRole())) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        req.setAttribute("account", acc);
        req.getRequestDispatcher("views/customer/home.jsp").forward(req, resp);
    }
}
