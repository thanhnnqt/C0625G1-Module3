package com.example.database.service;

import com.example.database.entity.Student;
import com.example.database.repository.IStudentRepository;
import com.example.database.repository.StudentRepository;

import java.util.List;

public class StudentService implements IStudentService{
    private final IStudentRepository studentRepository = new StudentRepository();
    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public boolean add(Student student) {
        return studentRepository.add(student);
    }
}
