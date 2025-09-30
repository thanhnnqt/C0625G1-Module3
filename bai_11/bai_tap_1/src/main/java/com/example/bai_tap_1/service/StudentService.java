package com.example.bai_tap_1.service;


import com.example.bai_tap_1.entity.Student;
import com.example.bai_tap_1.repository.IStudentRepository;
import com.example.bai_tap_1.repository.StudentRepository;

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
