package org.example.Repository.IMPL;

import org.example.DTO.Faculty;
import org.example.DTO.Student;
import org.example.Repository.FacultyRepository;
import org.example.util.ConnectionManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
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
