package org.example.Repository.IMPL;

import org.example.DTO.Phone;
import org.example.Repository.PhoneRepository;
import org.example.util.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PhoneRepositoryIMPLJDBC implements PhoneRepository {
    List<Phone> phoneArrayList = new ArrayList<>();
    Statement statement = null;

    public List<Phone> addPhoneByStudentID(UUID studentID, String phoneNumber) {
        String insertFaculty = "INSERT INTO public.Phones(student_id,number_phone) VALUES  (?,?)";
        try {
            PreparedStatement preparedStatement = ConnectionManager.open().prepareStatement(insertFaculty);
            preparedStatement.setObject(1, studentID);
            preparedStatement.setString(2, phoneNumber);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return phoneArrayList;
    }

    @Override
    public List<Phone> getPhoneByStudentID(UUID studentID) {

        try {
            statement = ConnectionManager.open().createStatement();
            String select = "SELECT * FROM phones\n" +
                    "WHERE student_id = \"StudyInUniversity\".public.students.id";
            ResultSet resultSet = statement.executeQuery(select);
            while (resultSet.next()) {
                phoneArrayList.add(new Phone(UUID.fromString(resultSet.getString("id")),
                        resultSet.getString("number_of_phone"),
                        UUID.fromString(resultSet.getString("studentID"))));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return phoneArrayList;
    }
}
