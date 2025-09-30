package com.example.database.controller;

import com.example.database.entity.Student;
import com.example.database.service.IStudentService;
import com.example.database.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
                req.setAttribute("studentList1", studentList1);
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
