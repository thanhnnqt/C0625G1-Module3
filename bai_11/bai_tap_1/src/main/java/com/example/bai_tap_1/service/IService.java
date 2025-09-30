package com.example.bai_tap_1.service;


import com.example.bai_tap_1.entity.Student;

import java.util.List;

public interface IService {
    List<Student> findAll();
    boolean add(Student student);
}
