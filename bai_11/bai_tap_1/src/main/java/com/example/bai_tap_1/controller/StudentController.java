package com.example.bai_tap_1.controller;

import com.example.bai_tap_1.entity.Student;
import com.example.bai_tap_1.service.IStudentService;
import com.example.bai_tap_1.service.StudentService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentController", value = "/students")
public class StudentController extends HttpServlet {
    IStudentService studentService = new StudentService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                // trả về form thêm mới
                req.getRequestDispatcher("views/students/add.jsp").forward(req, resp);
                break;
            case "delete":
                // xoá
                break;
            default:
                List<Student> studentList = studentService.findAll();
                req.setAttribute("studentList", studentList);
                req.getRequestDispatcher("views/students/list.jsp").forward(req, resp);
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
                boolean gender = Boolean.parseBoolean(req.getParameter("gender"));
                float score = Float.parseFloat(req.getParameter("score"));
                String classId = req.getParameter("class_id");
                Student student = new Student(id, name, gender, score, classId);
                studentService.add(student);
                List<Student> studentList1 = studentService.findAll();
                req.setAttribute("studentList", studentList1);
                req.getRequestDispatcher("views/students/list.jsp").forward(req, resp);
                break;
            case "delete":
                // xoá
                break;
            default:
                List<Student> studentList = studentService.findAll();
                req.setAttribute("studentList", studentList);
                req.getRequestDispatcher("views/students/list.jsp").forward(req, resp);
        }
    }
}
