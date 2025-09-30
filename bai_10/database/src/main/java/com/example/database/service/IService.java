package com.example.database.service;

import com.example.database.entity.Student;

import java.util.List;

public interface IService {
    List<Student> findAll();
    boolean add(Student student);
}
