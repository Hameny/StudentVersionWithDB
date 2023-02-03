package org.example.Repository.IMPL;

import org.example.DTO.Teacher;
import org.example.Repository.TeacherRepository;
import org.example.util.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TeacherRepositoryIMPL implements TeacherRepository {
    List<Teacher> teacherArrayList = new ArrayList<>();
    Statement statement = null;

    @Override
    public List<Teacher> addNewTeacher(String firstName, String secondName, UUID subjectID) {
        String insertTeacher = "INSERT INTO teachers (first_name,second_name,subject_id )VALUES (?,?,?);";
        try {
            PreparedStatement preparedStatement = ConnectionManager.open().prepareStatement(insertTeacher);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, secondName);
            preparedStatement.setObject(3, subjectID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return teacherArrayList;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        try {
            statement = ConnectionManager.open().createStatement();
            String select = "SELECT * FROM teachers";
            ResultSet resultSet = statement.executeQuery(select);
            while (resultSet.next()) {
                teacherArrayList.add(new Teacher(UUID.fromString(resultSet.getString("id")),
                        resultSet.getString("first_name"),resultSet.getString("second_name"),
                        UUID.fromString(resultSet.getString("subject_id"))));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return teacherArrayList;
    }
}
