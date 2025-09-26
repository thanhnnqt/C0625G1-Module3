package com.example.product_discount_calculator;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "DiscountServlet", value = "/discount")
public class DiscountServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        System.out.println("-----------Get run-------------");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("form-discount.jsp");
        requestDispatcher.forward(req, resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        System.out.println("------------Post run-------------");
        String text = req.getParameter("t1");
        int num1 = Integer.parseInt(req.getParameter("n1"));
        int num2 = Integer.parseInt(req.getParameter("n2"));
        double discount = num1 * num2 * 0.01;
        req.setAttribute("discount", discount);
        req.setAttribute("num1", num1);
        req.setAttribute("num2", num2);
        req.setAttribute("text", text);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("form-discount.jsp");
        requestDispatcher.forward(req, resp);
    }
}