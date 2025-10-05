package com.example.test.controller;

import com.example.test.entity.LiquidationContract;
import com.example.test.service.ILiquidationService;
import com.example.test.service.LiquidationService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet (name = "LiquidationContractController", value = "/liquidation-contract")
public class LiquidationContractController extends HttpServlet {
    ILiquidationService liquidationService = new LiquidationService();

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
                listContract(req, resp);
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
                listContract(req, resp);
                break;
        }
    }
    private void listContract(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException{
        String searchName = req.getParameter("liquidation_contract_id");
        String searchCategory = req.getParameter("productId");

        List<LiquidationContract> liquidationContractList;
        if ((searchName != null && !searchName.isEmpty()) ||
                (searchCategory != null && !searchCategory.isEmpty())) {
            liquidationContractList = liquidationService.search(searchName, searchCategory);
        } else {
            liquidationContractList = liquidationService.findAll();
        }
//        List<Product> products = categoryService.findAll();
        req.setAttribute("contracts", liquidationContractList);
//        req.setAttribute("categories", categories);
        req.setAttribute("selectedCategory", searchCategory);
        req.setAttribute("searchName", searchName);
        req.getRequestDispatcher("views/list.jsp").forward(req, resp);
    }

    private void updateProduct(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void createProduct(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void deleteProduct(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void showCreateForm(HttpServletRequest req, HttpServletResponse resp) {
    }
}
