package com.example.bai_tap_1.repository;


import com.example.bai_tap_1.entity.Student;

import java.util.List;

public interface IRepository {
    List<Student> findAll();
    boolean add(Student student);
}
