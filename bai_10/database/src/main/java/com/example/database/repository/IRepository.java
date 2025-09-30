package com.example.database.repository;

import com.example.database.entity.Student;

import java.util.List;

public interface IRepository {
    List<Student> findAll();
    boolean add(Student student);
}
