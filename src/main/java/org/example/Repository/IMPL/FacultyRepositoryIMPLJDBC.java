package org.example.Repository.IMPL;

import org.example.DTO.Faculty;
import org.example.Repository.FacultyRepository;
import org.example.util.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FacultyRepositoryIMPLJDBC implements FacultyRepository {
    List<Faculty> facultyArrayList = new ArrayList<>();
    Statement statement = null;


    @Override
    public List<Faculty> getALLFaculties() {
        try {
            statement = ConnectionManager.open().createStatement();
            String select = "SELECT * FROM Faculties";
            ResultSet resultSet = statement.executeQuery(select);
            while (resultSet.next()) {
                facultyArrayList.add(new Faculty(UUID.fromString(resultSet.getString("id")),
                        resultSet.getString("name_of_faculty")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return facultyArrayList;
    }

    @Override
    public List<Faculty> addNewFaculty(String nameOfFaculty) {
        String insertFaculty = "INSERT INTO public.faculties(name_of_faculty) VALUES  (?)";
        try {
            PreparedStatement preparedStatement = ConnectionManager.open().prepareStatement(insertFaculty);
            preparedStatement.setString(1, nameOfFaculty);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return facultyArrayList;
    }
}
