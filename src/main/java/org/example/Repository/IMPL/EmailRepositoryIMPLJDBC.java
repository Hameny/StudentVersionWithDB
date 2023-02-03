package org.example.Repository.IMPL;

import org.example.DTO.Email;
import org.example.Repository.EmailRepository;
import org.example.util.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class EmailRepositoryIMPLJDBC implements EmailRepository {
    List<Email> emailArrayList = new ArrayList<>();
    Statement statement = null;

    @Override
    public List<Email> addEmailByStudentID(UUID student_id, String email) {
        String insertFaculty = "INSERT INTO public.emails(email,student_id) VALUES  (?,?)";
        try {
            PreparedStatement preparedStatement = ConnectionManager.open().prepareStatement(insertFaculty);
            preparedStatement.setString(1, email);
            preparedStatement.setObject(2, student_id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return emailArrayList;
    }

    @Override
    public List<Email> getEmailByStudentID() {
        try {
            statement = ConnectionManager.open().createStatement();
            String select = "SELECT FROM emails\n" +
                    "WHERE student_id = \"StudyInUniversity\".public.students.id";
            ResultSet resultSet = statement.executeQuery(select);
            while (resultSet.next()) {
                emailArrayList.add(new Email(UUID.fromString(resultSet.getString("id")),
                        resultSet.getString("email"), UUID.fromString(resultSet.getString("studentID"))));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return emailArrayList;
    }
}
