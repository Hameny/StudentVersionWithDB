package org.example.Repository.IMPL;

import org.example.DTO.Student;
import org.example.Repository.StudentRepository;
import org.example.util.ConnectionManager;

import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class StudentRepositoryIMPLJDBC implements StudentRepository {
    List<Student> studentList = new ArrayList<>();
    Statement statement = null;

    @Override
    public List<Student> getAllStudents() {

        try {
            statement = ConnectionManager.open().createStatement();
            String select = "SELECT * FROM Students";
            ResultSet resultSet = statement.executeQuery(select);
            while (resultSet.next()) {
                studentList.add(new Student(UUID.fromString(resultSet.getString("id")),
                        resultSet.getString("first_name"), resultSet.getString("second_name"),
                        resultSet.getDate("date_of_birthday"), resultSet.getBoolean("isDelete")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return studentList;
    }

    @Override
    public List<Student> addNewStudent(String firstName, String secondName, Date dateOfBirthday) {
        String insertStudent = "INSERT INTO Students VALUES (?,?,?)";
        try {
            PreparedStatement preparedStatement = ConnectionManager.open().prepareStatement(insertStudent);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, secondName);
            preparedStatement.setObject(3,dateOfBirthday, Types.DATE);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return studentList;
    }

    @Override
    public List<Student> deleteStudentByID(UUID id) {
        return null;
    }
}
