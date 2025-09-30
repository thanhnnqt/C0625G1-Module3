package com.example.bai_tap_1.repository;

import com.example.bai_tap_1.entity.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository{
    private final static String SELECT_ALL = "select * from student";
    private final static String ADD_NEW = "insert into student(name, gender, score, class_id) value (?,?,?,?)";

    @Override
    public List<Student> findAll() {
        Connection connection = BaseRepository.getConnectDB();
        List<Student> studentList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                boolean gender = resultSet.getBoolean("gender");
                float score = resultSet.getFloat("score");
                String classId = resultSet.getString("class_id");
                Student student = new Student(id, name, gender, score, classId);
                studentList.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return studentList;
    }

    @Override
    public boolean add(Student student) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_NEW);
                preparedStatement.setString(1, student.getName());
                preparedStatement.setBoolean(2, student.isGender());
                preparedStatement.setFloat(3, student.getScore());
                preparedStatement.setString(4, student.getClassId());
                int row = preparedStatement.executeUpdate();
                return row == 1;
        } catch (SQLException e) {
            System.out.println("lỗi");
            return false;
        }
    }
}
