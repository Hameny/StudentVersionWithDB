package org.example.Repository.IMPL;

import org.example.DTO.Mark;
import org.example.Repository.MarkRepository;
import org.example.util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class MarkRepositoryIMPLJDBC implements MarkRepository {
    Statement statement = null;
    List<Mark> markList = new ArrayList<>();
    @Override
    public List<Mark> addMArkBySpecializationID(UUID studentSubjectID, UUID teacherID, Date dateMark, int mark) {
        String insertStudent = "insert into public.mark (student_subject_id, teacher_id, \"date\", mark)\n" +
                "values (?,?,?,?);";
        try {
            PreparedStatement preparedStatement = ConnectionManager.open().prepareStatement(insertStudent);
            preparedStatement.setObject(1, studentSubjectID);
            preparedStatement.setObject(2, teacherID);
            preparedStatement.setObject(3, dateMark, Types.DATE);
            preparedStatement.setInt(4, mark);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return markList;
    }

    @Override
    public List<Mark> getAllMarks() {
        try {
            statement = ConnectionManager.open().createStatement();
            String select = "SELECT * FROM mark";
            ResultSet resultSet = statement.executeQuery(select);
            while (resultSet.next()) {
                markList.add(new Mark(UUID.fromString(resultSet.getString("id")),
                        UUID.fromString(resultSet.getString("student_subject_id")),
                                UUID.fromString(resultSet.getString("teacher_id")),
                        resultSet.getDate("date"), resultSet.getInt("mark")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return markList;
    }
}
